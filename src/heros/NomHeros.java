import java.util.ArrayList;

public class NomHeros {
    private static ArrayList<String> tousHeros = new ArrayList<>();
    private String caracteresPermis = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
    private String nom;

    public NomHeros(String nom) {
        if (nom.length() < 2 || nom.length() > 30) {
            throw new IllegalArgumentException("La longueur du nom est moins que 2 lettres ou plus que 30 lettres.");
        } else {
            for (int i = 0; i < nom.length(); i++) {
                if (!caracteresPermis.contains(String.valueOf(nom.charAt(i)))) {
                    throw new IllegalArgumentException("Le nom contient un ou des caractères invalides.");
                }
            }
            if (String.valueOf(nom.charAt(0)).equals(" ") || String.valueOf(nom.charAt(nom.length() - 1)).equals(" ")) {
                throw new IllegalArgumentException("Le nom commence ou se termine avec un espace.");
            } else {
                if (tousHeros.contains(String.valueOf(nom))) {
                    throw new IllegalArgumentException("Le nom est déjà enregistré dans le système.");
                }
                this.nom = nom;
            }
        }
    }
}
