package heros.species;

import heros.Ability;

public final class Dwarf implements Species {

	@Override
	public String getName() {
		return "Dwarf";
	}

	@Override
	public int getModifier(Ability ability) {
		switch (ability) {
			case CONSTITUTION:
				return 2;
			case STRENGTH:
				return 1;
			default:
				return 0;
		}
	}
}
