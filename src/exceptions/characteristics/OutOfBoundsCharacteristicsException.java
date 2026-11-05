package exceptions.characteristics;

public class OutOfBoundsCharacteristicsException extends RuntimeException {
    public OutOfBoundsCharacteristicsException(String characteristicName, int characteristicValue) {
        super("The characteristic " + characteristicName + " is " +  characteristicValue + ", which is under 3 or over 20.");
    }
}
