package InventoryEquipment;
import Dice.Dice;
public class PotionDeSoin  implements  Items{
    @Override
    public String getName() {
        return "Potion de soin";
    }

    public int calculSoin(Dice dice) {
        if (dice == null) {
            throw new IllegalArgumentException(
                    "Le dé est obligatoire."
            );
        }

        return dice.dice4() + dice.dice4() + 2;
    }
}
