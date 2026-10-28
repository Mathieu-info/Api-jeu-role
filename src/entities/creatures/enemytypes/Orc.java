package entities.creatures.enemytypes;

import entities.attacks.Axe;
import entities.attacks.Club;
import entities.creatures.Enemy;
import general.ArmorClass;
import general.EntityName;
import general.ExperiencePoints;
import general.HealthScaling;
import general.Initiative;
import general.Level;

public class Orc extends Enemy {

	private static final int BASE_MAX_HEALTH = 15;
	private static final int HEALTH_GROWTH_PER_LEVEL = 15;

	public Orc(Level level, Initiative initiative) {
		super(
			new Level(1),
			new Initiative(1),
			BASE_MAX_HEALTH,
			HealthScaling.linear(HEALTH_GROWTH_PER_LEVEL),
			new EntityName("Orc"),
			new ExperiencePoints(100),
			new ArmorClass(13),
			new Axe(),
			new Club()
		);
	}

	public String rage() {
		return getName() + " lets out a furious war cry!";
	}
}
