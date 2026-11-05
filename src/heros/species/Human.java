package heros.species;

import heros.Ability;

public final class Human implements Species {

	@Override
	public String getName() {
		return "Human";
	}

	@Override
	public int getModifier(Ability ability) {
		return 1;
	}
}
