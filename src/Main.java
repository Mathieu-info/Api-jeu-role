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

		System.out.println(goblin.daggerAttack());
		System.out.println(orc.rage());
		System.out.println(troll.trollAttack());
	}
}
