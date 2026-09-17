package exceptions.name;

public class IllegalNameException extends Exception {
    public IllegalNameException(String nom) {
        super("The name [" + nom + "] contains illegal characters.");
    }
}
