package entities.creatures;

import general.ArmorClass;
import general.EntityName;
import general.ExperiencePoints;
import general.Health;

public class Enemy {

	private Health health;
	private EntityName name;
	private ExperiencePoints exp;
	private ArmorClass armorClass;

	public Enemy(
		Health health,
		EntityName name,
		ExperiencePoints exp,
		ArmorClass armorClass
	) {
		this.health = health;
		this.name = name;
		this.exp = exp;
		this.armorClass = armorClass;
	}

	public Health getHealth() {
		return health;
	}

	public EntityName getName() {
		return name;
	}

	public ExperiencePoints getExp() {
		return exp;
	}

	public ArmorClass getArmorClass() {
		return armorClass;
	}

	public void takeDamage(int damage) {
		health.takeDamage(damage);
	}

	public String toString() {
		return String.format(
			"Name : %s,\nHealth : %s,\nExp : %s,\nArmor Class : %s",
			name,
			health,
			exp,
			armorClass
		);
	}
}
