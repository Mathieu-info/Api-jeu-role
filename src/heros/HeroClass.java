package heros;

import exceptions.heroClass.IllegalHeroClassException;

public class HeroClass {
    private String className;

    public int getMagic() {
        return magic;
    }

    public int getBaseHealth() {
        return baseHealth;
    }

    private int baseHealth;
    private int magic;
    private String[] equipment; /// À changer pour l'attribut équipement
    private String aptitude;

    HeroClass(String className) {
        if (className.equals("Guerrier")) {
            this.className = "Guerrier";
            baseHealth = 12;
            magic = 0;
            equipment = new String[2];
            equipment[0] = "Épée longue";
            equipment[1] = "Armure de mailles";
            aptitude = "Force";
        } else if (className.equals("Rôdeur")) {
            this.className = "Rôdeur";
            baseHealth = 10;
            magic = 0;
            equipment = new String[2];
            equipment[0] = "Arc";
            equipment[1] = "Armure de cuir";
            aptitude = "Dextérité ";
        } else if (className.equals("Mage")) {
            this.className = "Mage";
            baseHealth = 6;
            magic = 10;
            equipment = new String[1];
            equipment[0] = "Bâton";
            aptitude = "Intelligence ";
        } else if (className.equals("Clerc")) {
            this.className = "Clerc";
            baseHealth = 10;
            magic = 8;
            equipment = new String[2];
            equipment[0] = "Masse";
            equipment[1] = "Armure de mailles";
            aptitude = "Sagesse ";
        } else {
            throw new IllegalHeroClassException(className);
        }
    }

}
