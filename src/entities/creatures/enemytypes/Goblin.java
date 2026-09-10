package entities.creatures.enemytypes;

import entities.creatures.Enemy;
import general.ArmorClass;
import general.EntityName;
import general.ExperiencePoints;
import general.Health;

public class Goblin extends Enemy {

	public Goblin() {
		super(
			new Health(40, 40),
			new EntityName("Goblin"),
			new ExperiencePoints(10),
			new ArmorClass(12)
		);
	}

	public String daggerAttack() {
		return getName() + " used its dagger!";
	}
}
