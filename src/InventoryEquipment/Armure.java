package InventoryEquipment;
import heros.CaracteristiqueHeros;
public class Armure  implements Items {
    private final String nom;
    private final int nombreBaseArmure;
    private final boolean bonusDexterite;

    public Armure(String nom, int nombreBaseArmure, boolean bonusDexterite) {

        this.nom = nom;
        this.nombreBaseArmure = nombreBaseArmure;
        this.bonusDexterite = bonusDexterite;
    }

    @Override
    public String getName() {
        return nom;
    }

    public int getNombreBaseArmure() {
        return nombreBaseArmure;
    }

    public int calculArmure(
            CaracteristiqueHeros caracteristiquesHeros) {

        if (caracteristiquesHeros == null) {
            throw new IllegalArgumentException(
                    "Les caractéristiques sont obligatoires."
            );
        }

        if (bonusDexterite) {
            return nombreBaseArmure
                    + caracteristiquesHeros.getModifier("Dextérité");
        }

        return nombreBaseArmure;
    }
}