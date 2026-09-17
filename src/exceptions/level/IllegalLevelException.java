package exceptions.level;

public class IllegalLevelException extends RuntimeException {

	private final int level;

	public IllegalLevelException(int level) {
		super("Level must be at least 1. Level entered: " + level);
		this.level = level;
	}

	public int getLevel() {
		return level;
	}
}