package heros.species;

import heros.Ability;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public interface Species {
	String getName();

	int getModifier(Ability ability);

	default int getBonus(String characteristicName) {
		Ability ability = Ability.fromName(characteristicName);
		return ability == null ? 0 : getModifier(ability);
	}

	default Map<String, Integer> getBonuses() {
		Map<String, Integer> bonuses = new HashMap<>();
		for (Ability ability : Ability.values()) {
			bonuses.put(ability.getDisplayName(), getModifier(ability));
		}
		return bonuses;
	}

	default Map<Ability, Integer> getModifierMap() {
		Map<Ability, Integer> modifiers = new EnumMap<>(Ability.class);
		for (Ability ability : Ability.values()) {
			modifiers.put(ability, getModifier(ability));
		}
		return modifiers;
	}
}
