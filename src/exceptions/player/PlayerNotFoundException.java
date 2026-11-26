package exceptions.player;

import api.ApiError;

public class PlayerNotFoundException extends PlayerException {

	public PlayerNotFoundException() {
		super(
			new ApiError(404, "PLAYER_NOT_FOUND", "Player not found.")
		);
	}
}
