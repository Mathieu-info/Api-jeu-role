public class Enemy {

	private Health health;
	private EntityName name;
	private ExperiencePoints exp;

	public Enemy(Health health, EntityName name, ExperiencePoints exp) {
		this.health = health;
		this.name = name;
		this.exp = exp;
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

	public void takeDamage(int damage) {
		health.takeDamage(damage);
	}
}
