package heros.species;

import heros.Ability;
import java.util.Map;

public abstract class AbstractSpecies implements Species {

	private final String name;
	private final Map<Ability, Integer> modifiers;

	protected AbstractSpecies(String name, Map<Ability, Integer> modifiers) {
		this.name = name;
		this.modifiers = Map.copyOf(modifiers);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getModifier(Ability ability) {
		return modifiers.getOrDefault(ability, 0);
	}
}
