package exceptions.player;

import api.ApiError;

public class EmailTakenException extends PlayerException {

	public EmailTakenException() {
		super(
			new ApiError(409, "EMAIL_TAKEN", "This email is already in use.")
		);
	}
}
