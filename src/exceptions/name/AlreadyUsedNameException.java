package exceptions.name;

public class AlreadyUsedNameException extends RuntimeException {
    public AlreadyUsedNameException(String name) {
        super("The name [" + name + "] is already used by another character");
    }
}
