package exceptions.session;

import api.ApiError;
import exceptions.ApiException;

public abstract class SessionException extends ApiException {

	protected SessionException(ApiError error) {
		super(error);
	}

	protected SessionException(ApiError error, String detail) {
		super(error, detail);
	}
}
