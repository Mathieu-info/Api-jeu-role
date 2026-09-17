package entities.creatures.enemytypes;

import entities.attacks.Axe;
import entities.attacks.Club;
import entities.creatures.Enemy;
import general.ArmorClass;
import general.EntityName;
import general.ExperiencePoints;
import general.HealthScaling;
import general.Level;

public class Orc extends Enemy {

	private static final int BASE_MAX_HEALTH = 70;
	private static final int HEALTH_GROWTH_PER_LEVEL = 15;

	public Orc(Level level) {
		super(
			level,
			BASE_MAX_HEALTH,
			HealthScaling.linear(HEALTH_GROWTH_PER_LEVEL),
			new EntityName("Orc"),
			new ExperiencePoints(25),
			new ArmorClass(14),
			new Axe(),
			new Club()
		);
	}

	public String rage() {
		return getName() + " lets out a furious war cry!";
	}
}