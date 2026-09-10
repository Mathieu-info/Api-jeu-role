package entities.attacks;

public record AttackResult(String message, int damage) {

	@Override
	public String toString() {
		return message;
	}
}