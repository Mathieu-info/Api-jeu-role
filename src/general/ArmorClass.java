package general;

public class ArmorClass {

	private int value;

	public ArmorClass(int value) {
		if (value < 0) {
			throw new IllegalArgumentException(
				"Armor class value cannot be negative"
			);
		}
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
