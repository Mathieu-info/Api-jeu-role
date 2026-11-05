package heros.species;

import heros.Ability;

import java.util.Map;

public final class Dwarf extends AbstractSpecies {

    private static final Map<Ability, Integer> MODIFIERS = Map.of(
            Ability.CONSTITUTION, 2,
            Ability.STRENGTH, 1
    );

    public Dwarf() {
        super("Dwarf", MODIFIERS);
    }
}