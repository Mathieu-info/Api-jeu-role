package entities.creatures;

import entities.attacks.Attack;
import entities.attacks.AttackResult;
import general.ArmorClass;
import general.EntityName;
import general.ExperiencePoints;
import general.Health;
import java.util.Arrays;

public abstract class Enemy {

	private Health health;
	private EntityName name;
	private ExperiencePoints exp;
	private ArmorClass armorClass;
	private Attack[] attacks;

	protected Enemy(
		Health health,
		EntityName name,
		ExperiencePoints exp,
		ArmorClass armorClass,
		Attack... attacks
	) {
		if (attacks.length == 0) {
			throw new IllegalArgumentException(
				"an enemy needs at least one attack"
			);
		}
		this.health = health;
		this.name = name;
		this.exp = exp;
		this.armorClass = armorClass;
		this.attacks = attacks;
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

	public Attack[] getAttacks() {
		return Arrays.copyOf(attacks, attacks.length);
	}

	public AttackResult attack(int index) {
		Attack attack = attacks[index];
		return new AttackResult(
			getName() +
				" has attacked. It has dealt " +
				attack.getDamage() +
				" damage",
			attack.getDamage()
		);
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
