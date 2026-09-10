package entities.creatures;

import general.ArmorClass;
import general.EntityName;
import general.ExperiencePoints;
import general.Health;

public abstract class Enemy {

	private Health health;
	private EntityName name;
	private ExperiencePoints exp;
	private ArmorClass armorClass;

	protected Enemy(
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

	@Override
	public String toString() {
		return String.format(
			"%s,\n%s,\n%s,\n%s",
			name,
			health,
			exp,
			armorClass
		);
	}
}
