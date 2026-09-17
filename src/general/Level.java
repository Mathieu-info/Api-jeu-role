package general;

import exceptions.level.IllegalLevelException;

public class Level {

	private final int value;

	public Level(int value) {
		if (value < 1) {
			throw new IllegalLevelException(value);
		}
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.format("Level %s", value);
	}
}