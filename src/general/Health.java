package general;
import exceptions.health.*;

public class Health {

	private int current;
	private int max;

	public Health(int current, int max) {
		if (current < 0 || current > max) {
            throw new IllegalNegativeHealthException(current, max);
		}
		if (max <= 0) {
            throw new IllegalNegativeMaxHealthException(max);
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
