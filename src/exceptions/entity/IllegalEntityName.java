package exceptions.entity;

public class IllegalEntityName extends RuntimeException {
    public IllegalEntityName(String name) {
        super("The name " + name + " is invalid, names can only contains letters");
    }
}
