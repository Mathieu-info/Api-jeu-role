package exceptions.player;

import api.ApiError;

public class IllegalEmailException extends PlayerException {

	public IllegalEmailException() {
		super(
			new ApiError(400, "INVALID_REQUEST", "The email is invalid.")
		);
	}
}
