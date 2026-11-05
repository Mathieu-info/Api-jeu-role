package heros.species;

import heros.Ability;

public final class Elf implements Species {

	@Override
	public String getName() {
		return "Elf";
	}

	@Override
	public int getModifier(Ability ability) {
		switch (ability) {
			case DEXTERITY:
				return 2;
			case INTELLIGENCE:
				return 1;
			default:
				return 0;
		}
	}
}
