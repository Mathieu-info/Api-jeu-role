package exceptions.player;

import api.ApiError;

public abstract class PlayerException extends RuntimeException {

	private final ApiError error;

	protected PlayerException(ApiError error) {
		super(error.description());
		this.error = error;
	}

	protected PlayerException(ApiError error, String detail) {
		super(detail);
		this.error = error;
	}

	public ApiError apiError() {
		return error;
	}
}
