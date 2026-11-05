package heros;

import heros.species.Human;
import heros.species.Species;
import heros.species.SpeciesFactory;
import java.util.Map;

public class Heros {

	private int lienJoueur;
	private NomHeros nom;
	private HeroClass classHeros;
	private Species species;
	private HeroCharacteristics characteristics;
	private int niveau = 1;
	private int pointsExperience = 0;
	private int pointsVie;
	private int pointsVieMax;
	private int pointsMagie;
	private int pointsMagieMax;

	public Heros(int lienJoueur, NomHeros nom, HeroClass category) {
		this(lienJoueur, nom, category, new Human());
	}

	public Heros(
		int lienJoueur,
		NomHeros nom,
		HeroClass category,
		Species species
	) {
		this.lienJoueur = lienJoueur;
		this.nom = nom;
		this.classHeros = category;
		this.species = species;
		this.characteristics = new HeroCharacteristics(species);
		this.pointsVieMax = category.getBaseHealth();
		this.pointsVie = pointsVieMax;
		this.pointsMagieMax = category.getMagic();
		this.pointsMagie = pointsMagieMax;
	}

	public Heros(int lienJoueur, String nom, String category)
		throws exceptions.name.IllegalNameException {
		this(lienJoueur, nom, category, "Human");
	}

	public Heros(
		int lienJoueur,
		String nom,
		String category,
		String speciesName
	) throws exceptions.name.IllegalNameException {
		this(
			lienJoueur,
			new NomHeros(nom),
			new HeroClass(category),
			SpeciesFactory.create(speciesName)
		);
	}

	public Heros(int lienJoueur, String nom, String category, Species species)
		throws exceptions.name.IllegalNameException {
		this(lienJoueur, new NomHeros(nom), new HeroClass(category), species);
	}

	public String getNom() {
		return this.nom.getNom();
	}

	public HeroClass getClassHeros() {
		return classHeros;
	}

	public Species getSpecies() {
		return species;
	}

	public HeroCharacteristics getHeroCharacteristics() {
		return characteristics;
	}

	public Map<String, Integer> getCharacteristics() {
		return characteristics.getCharacteristics();
	}

	public int getNiveau() {
		return niveau;
	}

	public int getPointsExperience() {
		return pointsExperience;
	}

	public int getPointsVie() {
		return pointsVie;
	}

	public int getPointsVieMax() {
		return pointsVieMax;
	}

	public int getPointsMagie() {
		return pointsMagie;
	}

	public int getPointsMagieMax() {
		return pointsMagieMax;
	}
}
