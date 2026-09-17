package exceptions.attack;

public class IllegalAmountOfAttacksException extends RuntimeException {
    public IllegalAmountOfAttacksException() {
        super("This entity needs at least 1 attack");
    }
}
