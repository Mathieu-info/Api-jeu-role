package exceptions.session;

import api.ApiError;

public class InvalidCredentialsException extends SessionException {

	public InvalidCredentialsException() {
		super(
			new ApiError(
				401,
				"INVALID_CREDENTIALS",
				"Invalid email or password."
			)
		);
	}
}
