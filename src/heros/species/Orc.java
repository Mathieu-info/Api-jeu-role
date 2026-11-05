package heros.species;

import heros.Ability;

import java.util.Map;

public final class Orc extends AbstractSpecies {

    private static final Map<Ability, Integer> MODIFIERS = Map.of(
            Ability.STRENGTH, 2,
            Ability.CONSTITUTION, 1,
            Ability.INTELLIGENCE, -1
    );

    public Orc() {
        super("Orc", MODIFIERS);
    }
}