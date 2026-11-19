package exceptions.player;

import api.ApiError;

public class PseudonymTakenException extends PlayerException {

	public PseudonymTakenException() {
		super(
			new ApiError(409, "PSEUDONYM_TAKEN", "This pseudonym is already taken.")
		);
	}
}
