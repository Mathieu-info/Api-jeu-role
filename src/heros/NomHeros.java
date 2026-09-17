package heros;

import java.util.ArrayList;
import exceptions.IllegalNameException;
import exceptions.AlreadyUsedNameException;
import exceptions.IllegalNameLengthException;
import heros.*;

public class NomHeros {
    private static ArrayList<String> tousHeros = new ArrayList<>();
    private String caracteresPermis = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
    private String nom;

    public NomHeros(String nom) throws IllegalNameException {
        if (nom.length() < 2 || nom.length() > 30) {
           throw new IllegalNameLengthException();
        } else {
            for (int i = 0; i < nom.length(); i++) {
                if (!caracteresPermis.contains(String.valueOf(nom.charAt(i)))) {
                    throw new IllegalNameException(nom);
                }
            }
            if (String.valueOf(nom.charAt(0)).equals(" ") || String.valueOf(nom.charAt(nom.length() - 1)).equals(" ")) {
                throw new IllegalNameException(nom);
            } else {
                if (tousHeros.contains(String.valueOf(nom))) {
                    throw new AlreadyUsedNameException(nom);
                }
                this.nom = nom;
            }
        }
    }
}
