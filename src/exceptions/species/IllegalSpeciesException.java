package exceptions.species;

public class IllegalSpeciesException extends RuntimeException {
    public IllegalSpeciesException(String speciesName) {
        super("The species " + speciesName + " is not a valid hero species. "
                + "Use \"Human\", \"Elf\", \"Dwarf\" or \"Orc\".");
    }
}
