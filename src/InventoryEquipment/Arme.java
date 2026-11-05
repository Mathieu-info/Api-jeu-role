package InventoryEquipment;
import Dice.Dice;
import heros.CaracteristiqueHeros;

public class Arme implements Items {
    private final String nom;
    private final int facesDe;
    private final String caracteristique;

    public Arme(String nom, int facesDe, String caracteristique) {
        this.nom = nom;
        this.facesDe = facesDe;
        this.caracteristique = caracteristique;
    }

    @Override
    public String getName() {
        return nom;
    }

    public int getFacesDe() {
        return facesDe;
    }

    public String getCaracteristique() {
        return caracteristique;
    }

    public int calculerDegats(
            CaracteristiqueHeros caracteristiquesHeros,
            Dice dice) {

        if (caracteristiquesHeros == null || dice == null) {
            throw new IllegalArgumentException(
                    "Les paramètres sont obligatoires."
            );
        }

        int degats;

        switch (facesDe) {
            case 4:
                degats = dice.dice4();
                break;
            case 6:
                degats = dice.dice6();
                break;
            case 8:
                degats = dice.dice8();
                break;
            case 10:
                degats = dice.dice10();
                break;
            default:
                throw new IllegalStateException(
                        "Le dé n'est pas pris en charge."
                );
        }

        return Math.max(
                0,
                degats + caracteristiquesHeros.getModifier(caracteristique)
        );
    }
}
