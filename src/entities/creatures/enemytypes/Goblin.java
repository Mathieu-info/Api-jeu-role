package entities.creatures.enemytypes;

import entities.attacks.RustedDagger;
import entities.creatures.Enemy;
import general.ArmorClass;
import general.EntityName;
import general.ExperiencePoints;
import general.HealthScaling;
import general.Initiative;
import general.Level;

public class Goblin extends Enemy {

	private static final int BASE_MAX_HEALTH = 7;
	private static final int HEALTH_GROWTH_PER_LEVEL = 4;

	public Goblin() {
		super(
			new Level(1),
			new Initiative(2),
			BASE_MAX_HEALTH,
			HealthScaling.linear(HEALTH_GROWTH_PER_LEVEL),
			new EntityName("Goblin"),
			new ExperiencePoints(50),
			new ArmorClass(12),
			new RustedDagger()
		);
	}
}
