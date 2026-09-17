import heros.*;

public class Heros {
    private int lienJoueur;
    private NomHeros nom;
    private HeroClass category;
    private int niveau = 1;
    private int pointsExperience = 0;
    private int pointsVie;
    private int pointsVieMax; // get from class in constructor
    private int pointsMagie;
    private int pointsMagieMax; // get from class in constructor

    public Heros(int lienJoueur, NomHeros nom, HeroClass category) {
        this.lienJoueur = lienJoueur;
        this.nom = nom;
        this.category = category;
        this.pointsVieMax = category.getBaseHealth();
        this.pointsVie = pointsVieMax;
        this.pointsMagieMax = category.getMagic();
        this.pointsMagie = pointsMagieMax;
    }
}
