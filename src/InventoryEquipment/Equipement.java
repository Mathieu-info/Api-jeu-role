package InventoryEquipment;
import heros.CaracteristiqueHeros;

public class Equipement {
    private Arme armeEquipee;
    private Armure armureEquipee;
    private final Inventaire inventaire;

    public Equipement(Inventaire inventaire) {
        if (inventaire == null) {
            throw new IllegalArgumentException(
                    "L'inventaire est obligatoire."
            );
        }

        this.inventaire = inventaire;
    }

    public Arme getArmeEquipee() {
        return armeEquipee;
    }

    public Armure getArmureEquipee() {
        return armureEquipee;
    }

    public boolean equiperArme(Arme arme) {
        if (arme == null || !inventaire.possedeObjet(arme)) {
            return false;
        }

        armeEquipee = arme;
        return true;
    }

    public boolean equiperArmure(Armure armure) {
        if (armure == null || !inventaire.possedeObjet(armure)) {
            return false;
        }

        armureEquipee = armure;
        return true;
    }

    public void retirerArme() {
        armeEquipee = null;
    }

    public void retirerArmure() {
        armureEquipee = null;
    }

    public int calculerClasseArmure(
            CaracteristiqueHeros caracteristiquesHeros) {

        if (caracteristiquesHeros == null) {
            throw new IllegalArgumentException(
                    "Les caractéristiques sont obligatoires."
            );
        }

        if (armureEquipee == null) {
            return 10
                    + caracteristiquesHeros.getModifier("Dextérité");
        }

        return armureEquipee.calculArmure(caracteristiquesHeros);
    }
}
