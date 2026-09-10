package entities.creatures.enemytypes;

import entities.attacks.Axe;
import entities.attacks.Club;
import entities.creatures.Enemy;
import general.ArmorClass;
import general.EntityName;
import general.ExperiencePoints;
import general.Health;

public class Orc extends Enemy {

	public Orc() {
		super(
			new Health(70, 70),
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