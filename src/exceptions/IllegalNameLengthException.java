package exceptions;

public class IllegalNameLengthException extends RuntimeException {
    public IllegalNameLengthException() {

        super("The name has to be between 2 and 30 characters long");
    }
}
