import heros.NomHeros;

public class Heros {
    private int lienJoueur;
    private NomHeros nom;
    private HeroClass class;
    private int niveau = 1;
    private int pointsExperience = 0;
    private int pointsVie;
    private int pointsVieMax; // get from class in constructor
    private int pointsMagie;
    private int pointsMagieMax; // get from class in constructor

    public Heros(int lienJoueur, NomHeros nom, HeroClass class) {
        this.lienJoueur = lienJoueur;
        this.nom = nom;
        this.class = class;
        this.pointsVieMax = class.vieClass;
        this.pointsVie = pointsVieMax;
        this.pointsMagieMax = class.magieClass;
        this.pointsMagie = pointsMagieMax;
    }
}
