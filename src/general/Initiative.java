package general;

public class Initiative {

	private int value;

	public Initiative(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.format("%s", value);
	}
}
