package exceptions.health;

public class IllegalHealthException extends RuntimeException {
    public IllegalHealthException(int health, int maxHealth) {

        super("Health must be between 1 and " + maxHealth + ". Health entered: " + health);
    }
}
