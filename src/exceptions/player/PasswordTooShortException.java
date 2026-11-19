package exceptions.player;

import api.ApiError;

public class PasswordTooShortException extends PlayerException {

	public PasswordTooShortException() {
		super(
			new ApiError(
				422,
				"PASSWORD_TOO_SHORT",
				"The password must contain at least 8 characters."
			)
		);
	}
}
