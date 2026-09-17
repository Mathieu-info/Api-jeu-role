package exceptions.heroClass;

public class IllegalHeroClassException extends RuntimeException {
    public IllegalHeroClassException(String className) {
        super("The class " + className + " is not a valid hero class. Use \"Guerrier\", \"Rôdeur\", \"Mage\" or \"Clerc\" ");
    }
}
