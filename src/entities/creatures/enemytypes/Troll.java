package entities.creatures.enemytypes;

import entities.attacks.Club;
import entities.creatures.Enemy;
import general.ArmorClass;
import general.EntityName;
import general.ExperiencePoints;
import general.HealthScaling;
import general.Initiative;
import general.Level;

public class Troll extends Enemy {

	private static final int BASE_MAX_HEALTH = 35;
	private static final int HEALTH_GROWTH_PER_LEVEL = 30;

	public Troll(Level level, Initiative initiative) {
		super(
			new Level(1),
			new Initiative(0),
			BASE_MAX_HEALTH,
			HealthScaling.linear(HEALTH_GROWTH_PER_LEVEL),
			new EntityName("Troll"),
			new ExperiencePoints(300),
			new ArmorClass(15),
			new Club()
		);
	}
}
