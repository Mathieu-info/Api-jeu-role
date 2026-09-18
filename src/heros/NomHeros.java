package heros;

import java.util.ArrayList;
import exceptions.name.IllegalNameException;

public class NomHeros {
    private static ArrayList<String> tousNoms = new ArrayList();
    String regex = "^(?=.{2,30}$)[A-Za-zÀ-ÖØ-öø-ÿ]+(?: [A-Za-zÀ-ÖØ-öø-ÿ]+)*$";
    private String nom;

    public NomHeros(String nom) throws IllegalNameException {
        if (this.estValide(nom) && this.estUnique(nom)) {
            this.nom = nom;
            tousNoms.add(nom);
        } else {
            throw new IllegalArgumentException(nom);
        }
    }

    public String getNom() {
        return this.nom;
    }

    private boolean estValide(String nom) {
        return nom.matches(this.regex);
    }

    private boolean estUnique(String nom) {
        return !tousNoms.contains(nom);
    }
}
