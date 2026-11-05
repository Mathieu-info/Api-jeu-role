package heros.species;

import heros.Ability;

import java.util.Map;

public final class Human extends AbstractSpecies {

    private static final Map<Ability, Integer> MODIFIERS = Map.of(
            Ability.STRENGTH, 1,
            Ability.DEXTERITY, 1,
            Ability.CONSTITUTION, 1,
            Ability.INTELLIGENCE, 1,
            Ability.WISDOM, 1,
            Ability.CHARISMA, 1
    );

    public Human() {
        super("Human", MODIFIERS);
    }
}