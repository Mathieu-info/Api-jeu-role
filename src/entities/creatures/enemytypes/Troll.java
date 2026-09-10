package entities.creatures.enemytypes;

import entities.creatures.Enemy;
import general.ArmorClass;
import general.EntityName;
import general.ExperiencePoints;
import general.Health;

public class Troll extends Enemy {

	public Troll() {
		super(
			new Health(150, 150),
			new EntityName("Troll"),
			new ExperiencePoints(100),
			new ArmorClass(18)
		);
	}

	public String trollAttack() {
		return getName() + " has attacked you!";
	}
}
