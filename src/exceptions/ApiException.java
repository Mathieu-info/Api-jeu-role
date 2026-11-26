package exceptions;

import api.ApiError;

public abstract class ApiException extends RuntimeException {

	private final ApiError error;

	protected ApiException(ApiError error) {
		super(error.description());
		this.error = error;
	}

	protected ApiException(ApiError error, String detail) {
		super(detail);
		this.error = error;
	}

	public ApiError apiError() {
		return error;
	}
}
