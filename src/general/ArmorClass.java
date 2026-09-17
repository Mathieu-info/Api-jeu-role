package general;
import exceptions.armor.IllegalArmorAmount;

public class ArmorClass {

	private int value;

	public ArmorClass(int value) {
		if (value < 0) {
            throw new IllegalArmorAmount(value);
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
