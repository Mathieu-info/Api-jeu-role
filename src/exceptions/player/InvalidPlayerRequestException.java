package exceptions.player;

import api.ApiError;

public class InvalidPlayerRequestException extends PlayerException {

	public InvalidPlayerRequestException(String field) {
		super(
			new ApiError(400, "INVALID_REQUEST", "Invalid request."),
			"The field « " + field + " » is required."
		);
	}
}
