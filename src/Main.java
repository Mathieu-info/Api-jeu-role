import entities.attacks.AttackResult;
import entities.creatures.Enemy;
import entities.creatures.enemytypes.Goblin;
import entities.creatures.enemytypes.Orc;
import entities.creatures.enemytypes.Troll;

public class Main {

	public static void main(String[] args) {
		Goblin goblin = new Goblin();
		Orc orc = new Orc();
		Troll troll = new Troll();

		Enemy[] enemies = { goblin, orc, troll };

		for (Enemy enemy : enemies) {
			System.out.println(enemy);
			System.out.println();
		}

		System.out.println(orc.rage());
		System.out.println();

		for (Enemy enemy : enemies) {
			for (int i = 0; i < enemy.getAttacks().length; i++) {
				AttackResult result = enemy.attack(i);
				System.out.println(
					result.message() + " (" + result.damage() + " damage)"
				);
			}
			//System.out.println();
		}
	}
}
