package general;
import exceptions.experience.IllegalNegativeExperiencePoint;

public class ExperiencePoints {

	private int value;

	public ExperiencePoints(int value) {
		if (value < 0) {
            throw new IllegalNegativeExperiencePoint(value);
		}
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void add(int amount) {
		if (amount < 0) {
            throw new IllegalNegativeExperiencePoint(amount);
		}
		this.value += amount;
	}

	@Override
	public String toString() {
		return String.format("%s", value);
	}
}
