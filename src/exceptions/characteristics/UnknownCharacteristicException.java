package exceptions.characteristics;

public class UnknownCharacteristicException extends RuntimeException {

	public UnknownCharacteristicException(String characteristicName) {
		super("Unknown characteristic: " + characteristicName);
	}
}
