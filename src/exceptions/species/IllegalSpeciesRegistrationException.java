package exceptions.species;

public class IllegalSpeciesRegistrationException extends RuntimeException {
    public IllegalSpeciesRegistrationException() {
        super("A species name and species are required.");
    }
}
