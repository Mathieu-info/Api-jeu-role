package players;

import java.security.SecureRandom;

public final class PlayerId {

	private static final SecureRandom RANDOM = new SecureRandom();

	private final String value;

	private PlayerId(String value) {
		this.value = value;
	}

	public static PlayerId generate() {
		return new PlayerId(String.format("p-%08x", RANDOM.nextInt()));
	}

	public static PlayerId of(String value) {
		if (value == null || value.isBlank()) {
			throw new IllegalArgumentException("The player id is empty.");
		}
		return new PlayerId(value);
	}

	public String value() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PlayerId other)) return false;
		return value.equals(other.value);
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	@Override
	public String toString() {
		return value;
	}
}
