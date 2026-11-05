package heros;

import exceptions.characteristics.OutOfBoundsCharacteristicsException;
import heros.species.Human;
import heros.species.Species;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HeroCharacteristics {

	public static final int MIN_SCORE = 1;
	public static final int MAX_SCORE = 20;
	public static final int DEFAULT_BASE_SCORE = 10;

	private final String[] characteristicNames = {
		"Strength",
		"Dexterity",
		"Constitution",
		"Intelligence",
		"Wisdom",
		"Charisma",
	};

	private final Map<String, Integer> baseScores = new HashMap<>();
	private final Species species;

	public HeroCharacteristics() {
		this(new Human());
	}

	public HeroCharacteristics(Species species) {
		this(createDefaultBaseScores(), species);
	}

	public HeroCharacteristics(Map<String, Integer> baseScores) {
		this(baseScores, new Human());
	}

	public HeroCharacteristics(
		Map<String, Integer> baseScores,
		Species species
	) {
		this.species = Objects.requireNonNull(species, "species is required");
		for (String name : characteristicNames) {
			this.baseScores.put(name, DEFAULT_BASE_SCORE);
		}
		if (baseScores != null) {
			for (Map.Entry<String, Integer> entry : baseScores.entrySet()) {
				setBaseScore(entry.getKey(), entry.getValue());
			}
		}
	}

	private static Map<String, Integer> createDefaultBaseScores() {
		Map<String, Integer> defaults = new HashMap<>();
		for (String name : new String[] {
			"Strength",
			"Dexterity",
			"Constitution",
			"Intelligence",
			"Wisdom",
			"Charisma",
		}) {
			defaults.put(name, DEFAULT_BASE_SCORE);
		}
		return defaults;
	}

	public Species getSpecies() {
		return species;
	}

	public int getBaseScore(String characteristicName) {
		validateCharacteristicName(characteristicName);
		return baseScores.get(characteristicName);
	}

	public void setBaseScore(String characteristicName, int value) {
		validateCharacteristicName(characteristicName);
		if (value < MIN_SCORE || value > MAX_SCORE) {
			throw new OutOfBoundsCharacteristicsException(
				characteristicName,
				value
			);
		}
		baseScores.put(characteristicName, value);
	}

	public int getValue(String characteristicName) {
		validateCharacteristicName(characteristicName);
		return (
			baseScores.get(characteristicName) +
			species.getBonus(characteristicName)
		);
	}

	public int getModifier(String characteristicName) {
		int value = getValue(characteristicName);
		return Math.floorDiv(value - 10, 2);
	}

	public Map<String, Integer> getCharacteristics() {
		Map<String, Integer> result = new HashMap<>();
		for (String name : characteristicNames) {
			result.put(name, getValue(name));
		}
		return result;
	}

	public Map<String, Integer> getBaseScores() {
		return new HashMap<>(baseScores);
	}

	public Map<String, Integer> getSpeciesBonuses() {
		return species.getBonuses();
	}

	public Map<Ability, Integer> getAbilityScores() {
		Map<Ability, Integer> result = new EnumMap<>(Ability.class);
		for (Ability ability : Ability.values()) {
			result.put(ability, getValue(ability.getDisplayName()));
		}
		return result;
	}

	private void validateCharacteristicName(String characteristicName) {
		if (
			characteristicName == null ||
			!baseScores.containsKey(characteristicName)
		) {
			throw new IllegalArgumentException(
				"Unknown characteristic: " + characteristicName
			);
		}
	}
}
