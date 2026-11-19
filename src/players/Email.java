package players;

import exceptions.player.IllegalEmailException;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;

public final class Email {

	private static final Pattern FORMAT =
		Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}");

	private final String value;
	private final String normalized;

	public Email(String value) {
		if (value == null || !FORMAT.matcher(value).matches()) {
			throw new IllegalEmailException();
		}
		this.value = value;
		this.normalized = value.toLowerCase(Locale.ROOT);
	}

	public String value() {
		return value;
	}

	public String normalized() {
		return normalized;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Email other)) return false;
		return normalized.equals(other.normalized);
	}

	@Override
	public int hashCode() {
		return Objects.hash(normalized);
	}

	@Override
	public String toString() {
		return value;
	}
}
