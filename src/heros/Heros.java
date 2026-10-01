package heros;
import heros.*;
import java.util.Map;

public class Heros {
    private int lienJoueur;
    private NomHeros nom;
    private HeroClass classHeros;
    private CaracteristiqueHeros caracteristiques;
    private int niveau = 1;
    private int pointsExperience = 0;
    private int pointsVie;
    private int pointsVieMax; // get from class in constructor
    private int pointsMagie;
    private int pointsMagieMax; // get from class in constructor

    public Heros(int lienJoueur, String nom, String category) {
        this.lienJoueur = lienJoueur;
        try {
            this.nom = new NomHeros(nom);
        } catch (exceptions.name.IllegalNameException e) {
            System.err.println("Invalid name provided: " + e.getMessage());
        }

        this.classHeros = new HeroClass(category);
        this.caracteristiques = new CaracteristiqueHeros();
//        this.pointsVieMax = category.getBaseHealth();
        this.pointsVie = pointsVieMax;
//        this.pointsMagieMax = category.getMagic();
        this.pointsMagie = pointsMagieMax;
    }

    public String getNom() {
        return this.nom.getNom();
    }

    public Map<String, Integer> getCaracteristiques() {return this.caracteristiques.getCaracteristiques();}
}
