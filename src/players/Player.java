package players;

public class Player {

	private final PlayerId id;
	private final Pseudonym pseudonym;
	private final Email email;
	private final PasswordHash passwordHash;

	public Player(PlayerId id, Pseudonym pseudonym, Email email, PasswordHash passwordHash) {
		this.id = id;
		this.pseudonym = pseudonym;
		this.email = email;
		this.passwordHash = passwordHash;
	}

	public PlayerId getId() {
		return id;
	}

	public Pseudonym getPseudonym() {
		return pseudonym;
	}

	public Email getEmail() {
		return email;
	}

	public PasswordHash getPasswordHash() {
		return passwordHash;
	}
}
