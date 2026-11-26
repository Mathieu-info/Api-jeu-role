package exceptions.player;

import api.ApiError;
import exceptions.ApiException;

public abstract class PlayerException extends ApiException {

	protected PlayerException(ApiError error) {
		super(error);
	}

	protected PlayerException(ApiError error, String detail) {
		super(error, detail);
	}
}
