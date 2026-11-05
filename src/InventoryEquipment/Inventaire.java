package InventoryEquipment;

import java.util.HashMap;

public class Inventaire {
    private static final int CAPACITE_MAX = 10;

    private final HashMap<Integer, Items> objets = new HashMap<>();
    private int prochainId = 1;

    public boolean ajouterObjet(Items objet) {
        if (objet == null || estPlein()) {
            return false;
        }

        objets.put(prochainId, objet);
        prochainId++;

        return true;
    }

    public boolean possedeObjet(Items objet) {
        if (objet == null) {
            return false;
        }

        return objets.containsValue(objet);
    }

    public boolean retirerObjet(int id) {
        return objets.remove(id) != null;
    }

    public int getNombreObjets() {
        return objets.size();
    }

    public boolean estPlein() {
        return objets.size() >= CAPACITE_MAX;
    }

}
