package heros.species;

import heros.Ability;

import java.util.Map;

public final class Elf extends AbstractSpecies {

    private static final Map<Ability, Integer> MODIFIERS = Map.of(
            Ability.DEXTERITY, 2,
            Ability.INTELLIGENCE, 1
    );

    public Elf() {
        super("Elf", MODIFIERS);
    }
}