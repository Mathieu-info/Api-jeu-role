package application.players;

import exceptions.player.EmailTakenException;
import exceptions.player.InvalidPlayerRequestException;
import exceptions.player.PasswordTooShortException;
import exceptions.player.PseudonymTakenException;
import players.Email;
import players.PasswordHash;
import players.Player;
import players.PlayerId;
import players.Pseudonym;

public class CreatePlayer {

	public static final int MIN_PASSWORD_LENGTH = 8;

	private final PlayerRepository players;
	private final PasswordHasher passwordHasher;

	public CreatePlayer(PlayerRepository players, PasswordHasher passwordHasher) {
		this.players = players;
		this.passwordHasher = passwordHasher;
	}

	public PlayerAccount execute(CreatePlayerRequest request) {
		if (request == null) {
			throw new InvalidPlayerRequestException("body");
		}
		Pseudonym pseudonym = new Pseudonym(
			requireField(request.pseudonym(), "pseudonym")
		);
		Email email = new Email(requireField(request.email(), "email"));
		String password = requireField(request.password(), "password");

		if (password.length() < MIN_PASSWORD_LENGTH) {
			throw new PasswordTooShortException();
		}
		if (players.findByPseudonym(pseudonym).isPresent()) {
			throw new PseudonymTakenException();
		}
		if (players.findByEmail(email).isPresent()) {
			throw new EmailTakenException();
		}

		Player player = new Player(
			PlayerId.generate(),
			pseudonym,
			email,
			new PasswordHash(passwordHasher.hash(password))
		);
		players.save(player);
		return PlayerAccount.from(player);
	}

	private String requireField(String value, String field) {
		if (value == null || value.isBlank()) {
			throw new InvalidPlayerRequestException(field);
		}
		return value;
	}
}
