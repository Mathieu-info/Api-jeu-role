package Events;

public class Encounters {
    public static String[] encounters = {"Patrouille gobeline", "Campement orc", "Antre du Troll"};

    public void randomEncounter() {
        // nombre aléatoire entre 0 à nombre maximum de l'array
        int encounter = (int) (Math.random() * encounters.length); // noombre aléatoire necessite le type int
        // Condition qui appelle les méthodes necessaires
        System.out.println("==========================");
        System.out.println("Test de rencontre");
        if (encounters[encounter].equals("Patrouille gobeline")) {
            System.out.println("Patrouille gobeline");
        } else if(encounters[encounter].equals("Campement orc")) {
            System.out.println("Campement orc");
        } else if(encounters[encounter].equals("Antre du Troll")) {
            System.out.println("Antre du Troll");
        }
        System.out.println("==========================");
        System.out.println("==========================");
    }
}
