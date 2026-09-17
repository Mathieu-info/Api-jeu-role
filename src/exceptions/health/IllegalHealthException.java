package exceptions.health;

public class IllegalNegativeHealthException extends RuntimeException {
    public IllegalNegativeHealthException(int health, int maxHealth) {

        super("Health must be between 1 and " + maxHealth + ". Health entered: " + health);
    }
}
