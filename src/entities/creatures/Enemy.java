package entities.creatures;

import entities.attacks.Attack;
import entities.attacks.AttackResult;
import exceptions.armor.IllegalArmorAmount;
import general.ArmorClass;
import general.EntityName;
import general.ExperiencePoints;
import general.Health;
import general.HealthScaling;
import general.Level;
import java.util.Arrays;
import exceptions.attack.IllegalAmountOfAttacksException;

public abstract class Enemy {

	private Health health;
	private EntityName name;
	private ExperiencePoints exp;
	private ArmorClass armorClass;
	private Attack[] attacks;
	private Level level;

	protected Enemy(
		Level level,
		int baseMaxHealth,
		HealthScaling healthScaling,
		EntityName name,
		ExperiencePoints exp,
		ArmorClass armorClass,
		Attack... attacks
	) {
		if (attacks.length == 0) {
			throw new IllegalAmountOfAttacksException();
		}
		int maxHealth = healthScaling.computeMaxHealth(
			baseMaxHealth,
			level.getValue()
		);
		this.level = level;
		this.health = new Health(maxHealth, maxHealth);
		this.name = name;
		this.exp = exp;
		this.armorClass = armorClass;
		this.attacks = attacks;
	}

	public Health getHealth() {
		return health;
	}

	public Level getLevel() {
		return level;
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
				" has used " +
				attack.getName() +
				". It has dealt " +
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
			"%s,\n%s,\n%s,\n%s,\n%s",
			level,
			name,
			health,
			exp,
			armorClass
		);
	}
}
