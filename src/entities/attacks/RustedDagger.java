package entities.attacks;

public final class RustedDagger implements Attack {

	private static final String NAME = "Rusted Dagger";
	private static final int BASEDAMAGE = 4;

	@Override
	public int getDamage() {
		return BASEDAMAGE;
	}

	@Override
	public String getName() {
		return NAME;
	}
}
