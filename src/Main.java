import entities.creatures.Enemy;
import general.*;

public class Main {

	public static void main(String[] args) {
		Enemy enemy = new Enemy(
			new Health(100, 100),
			new EntityName("Goblin"),
			new ExperiencePoints(10),
			new ArmorClass(10)
		);
		System.out.println(enemy.getHealth());
		System.out.println(enemy.getName());
		System.out.println(enemy.getExp());
		System.out.println(enemy.getArmorClass());
	}
}
