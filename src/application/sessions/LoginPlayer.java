package application.sessions;

import application.players.PasswordHasher;
import application.players.PlayerRepository;
import exceptions.player.InvalidPlayerRequestException;
import exceptions.session.InvalidCredentialsException;
import players.Email;
import players.Player;

public class LoginPlayer {

	private static final String DUMMY_PASSWORD_HASH =
		"$pbkdf2-sha256$210000$CQ2KCXAA-lFHpFqAoZCnVw$SHMX568jpxNqqRTlPyNlmZVNJgCaxCDPYxs_dNF1u_I";

	private final PlayerRepository players;
	private final PasswordHasher passwordHasher;
	private final SessionTokens sessionTokens;

	public LoginPlayer(
		PlayerRepository players,
		PasswordHasher passwordHasher,
		SessionTokens sessionTokens
	) {
		this.players = players;
		this.passwordHasher = passwordHasher;
		this.sessionTokens = sessionTokens;
	}

	public Session execute(LoginRequest request) {
		if (request == null) {
			throw new InvalidPlayerRequestException("body");
		}
		Email email = new Email(requireField(request.email(), "email"));
		String password = requireField(request.password(), "password");

		Player player = players.findByEmail(email).orElse(null);
		String storedHash = player == null
			? DUMMY_PASSWORD_HASH
			: player.getPasswordHash().value();
		boolean passwordMatches = passwordHasher.verify(password, storedHash);
		if (player == null || !passwordMatches) {
			throw new InvalidCredentialsException();
		}

		return new Session(
			player.getId().value(),
			sessionTokens.issue(player.getId())
		);
	}

	private String requireField(String value, String field) {
		if (value == null || value.isBlank()) {
			throw new InvalidPlayerRequestException(field);
		}
		return value;
	}
}
