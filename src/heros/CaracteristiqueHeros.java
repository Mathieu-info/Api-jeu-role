package heros;

import exceptions.characteristics.OutOfBoundsCharacteristicsException;

import java.util.HashMap;
import java.util.Map;

public class CaracteristiqueHeros {
    private final Map<String, Integer> caracteristiques = new HashMap<>();
    private final String[] caracteristiqueNoms = {
            "Force", "Dextérité", "Constitution",
            "Intelligence", "Sagesse", "Charisme"
    };

    public CaracteristiqueHeros() {
        initCaracteristiques();
    } // temporaire

    private void initCaracteristiques() {
        for (int i = 0; i < this.caracteristiqueNoms.length; i++) {
            caracteristiques.put(this.caracteristiqueNoms[i], 3);
        }
    }

    private void checkCaracteristiques(String nomCaracteristique) throws OutOfBoundsCharacteristicsException {
        int value = this.caracteristiques.get(nomCaracteristique);
        if (value < 20 && value > 3) {
            System.out.println("Valeur valide pour " + nomCaracteristique); // temporaire
        } else {
            throw new OutOfBoundsCharacteristicsException(nomCaracteristique, value);
        }
    }

    public Map<String, Integer> getCaracteristiques() {
        return caracteristiques;
    }

    public int getValue(String nomCaracteristique) {
        return this.caracteristiques.get(nomCaracteristique);
    }

    public int getModifier(String nomCaracteristique) {
        int value = this.caracteristiques.get(nomCaracteristique);
        return Math.floorDiv((value - 10), 2);
    }
}
