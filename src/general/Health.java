package general;

public class Health {

	private int current;
	private int max;

	public Health(int current, int max) {
		if (current < 0 || current > max) {
			throw new IllegalArgumentException(
				"current must be between 0 and " + max
			);
		}
		if (max <= 0) {
			throw new IllegalArgumentException("max health must be positive");
		}
		this.current = current;
		this.max = max;
	}

	public int getCurrent() {
		return current;
	}

	public int getMax() {
		return max;
	}

	public void takeDamage(int damage) {
		current = Math.max(0, current - damage);
	}

	@Override
	public String toString() {
		return String.format("%s/%s", current, max);
	}
}
