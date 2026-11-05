package heros.species;

import heros.Ability;

public final class Orc implements Species {

	@Override
	public String getName() {
		return "Orc";
	}

	@Override
	public int getModifier(Ability ability) {
		switch (ability) {
			case STRENGTH:
				return 2;
			case CONSTITUTION:
				return 1;
			case INTELLIGENCE:
				return -1;
			default:
				return 0;
		}
	}
}
