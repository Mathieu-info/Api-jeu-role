package players;

public final class PasswordHash {

	private final String value;

	public PasswordHash(String value) {
		if (value == null || value.isBlank()) {
			throw new IllegalArgumentException("The password hash is empty.");
		}
		this.value = value;
	}

	public String value() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}
}
