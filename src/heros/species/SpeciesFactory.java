package heros.species;

import exceptions.species.IllegalSpeciesException;
import java.util.HashMap;
import java.util.Map;

public final class SpeciesFactory {

	private static final Map<String, Species> REGISTRY = new HashMap<>();

	static {
		register("Human", new Human());
		register("Elf", new Elf());
		register("Dwarf", new Dwarf());
		register("Orc", new Orc());
	}

	private SpeciesFactory() {}

	public static void register(String name, Species species) {
		if (name == null || name.trim().isEmpty() || species == null) {
			throw new IllegalArgumentException(
				"A species name and species are required."
			);
		}
		REGISTRY.put(normalize(name), species);
	}

	public static boolean isRegistered(String name) {
		return name != null && REGISTRY.containsKey(normalize(name));
	}

	public static Species create(String name) {
		Species species = REGISTRY.get(normalize(name));
		if (species == null) {
			throw new IllegalSpeciesException(name);
		}
		return species;
	}

	private static String normalize(String name) {
		return name.trim().toLowerCase();
	}
}
