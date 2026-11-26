package exceptions.player;

import api.ApiError;

public class ForbiddenException extends PlayerException {

	public ForbiddenException() {
		super(
			new ApiError(403, "FORBIDDEN", "This action is forbidden.")
		);
	}
}
