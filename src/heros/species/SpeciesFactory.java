package heros.species;

import exceptions.species.IllegalSpeciesException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Supplier;

public final class SpeciesFactory {

	private static final Map<String, Supplier<Species>> REGISTRY =
		new HashMap<>();

	static {
		register("Human", Human::new);
		register("Elf", Elf::new);
		register("Dwarf", Dwarf::new);
		register("Orc", Orc::new);
	}

	private SpeciesFactory() {}

	public static void register(String name, Supplier<Species> supplier) {
		if (name == null || name.trim().isEmpty() || supplier == null) {
			throw new IllegalArgumentException(
				"A species name and supplier are required."
			);
		}
		REGISTRY.put(normalize(name), supplier);
	}

	public static boolean isRegistered(String name) {
		return name != null && REGISTRY.containsKey(normalize(name));
	}

	public static Species create(String name) {
		Supplier<Species> supplier = REGISTRY.get(normalize(name));
		if (supplier == null) {
			throw new IllegalSpeciesException(name);
		}
		return supplier.get();
	}

	private static String normalize(String name) {
		return name.trim().toLowerCase(Locale.ROOT);
	}
}
