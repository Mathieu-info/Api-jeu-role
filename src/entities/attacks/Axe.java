package entities.attacks;

public final class Axe implements Attack {

	private static final String NAME = "Axe";
	private static final int BASEDAMAGE = 8;

	@Override
	public int getDamage() {
		return BASEDAMAGE;
	}

	@Override
	public String getName() {
		return NAME;
	}
}
