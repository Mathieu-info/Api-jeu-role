package entities.attacks;

public final class Club implements Attack {

	private static final String NAME = "Club";
	private static final int BASEDAMAGE = 6;

	@Override
	public int getDamage() {
		return BASEDAMAGE;
	}

	@Override
	public String getName() {
		return NAME;
	}
}
