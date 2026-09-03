public class ExperiencePoints {

	private int value;

	public ExperiencePoints(int value) {
		if (value < 0) {
			throw new IllegalArgumentException(
				"ExperiencePoints cannot be negative"
			);
		}
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void add(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Amount cannot be negative");
		}
		this.value += amount;
	}
}
