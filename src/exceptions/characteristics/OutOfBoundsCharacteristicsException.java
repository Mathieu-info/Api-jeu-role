package exceptions.characteristics;

public class OutOfBoundsCharacteristicsException extends RuntimeException {

	public OutOfBoundsCharacteristicsException(
		String characteristicName,
		int characteristicValue
	) {
		super(
			"The characteristic " +
				characteristicName +
				" is " +
				characteristicValue +
				", which is outside the allowed range of 1 to 20."
		);
	}
}
