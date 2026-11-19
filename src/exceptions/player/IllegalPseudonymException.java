package exceptions.player;

import api.ApiError;

public class IllegalPseudonymException extends PlayerException {

	public IllegalPseudonymException() {
		super(
			new ApiError(
				400,
				"INVALID_REQUEST",
				"The pseudonym must contain 3 to 20 characters: letters, numbers or underscore."
			)
		);
	}
}
