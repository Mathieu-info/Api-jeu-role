package exceptions.health;

public class IllegalNegativeMaxHealthException extends RuntimeException {
    public IllegalNegativeMaxHealthException(int maxHealth) {

        super("Max health must be a positive number! Max health entered: " + maxHealth);
    }
}
