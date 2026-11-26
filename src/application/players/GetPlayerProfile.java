package application.players;

import exceptions.player.ForbiddenException;
import exceptions.player.InvalidPlayerRequestException;
import exceptions.player.PlayerNotFoundException;
import players.Player;
import players.PlayerId;

public class GetPlayerProfile {

	private final PlayerRepository players;

	public GetPlayerProfile(PlayerRepository players) {
		this.players = players;
	}

	public PlayerAccount execute(GetPlayerProfileRequest request) {
		if (request == null) {
			throw new InvalidPlayerRequestException("request");
		}
		PlayerId playerId = PlayerId.of(
			requireField(request.playerId(), "playerId")
		);
		PlayerId requesterId = PlayerId.of(
			requireField(request.requesterId(), "requesterId")
		);

		Player player = players.findById(playerId)
			.orElseThrow(PlayerNotFoundException::new);
		if (!player.getId().equals(requesterId)) {
			throw new ForbiddenException();
		}
		return PlayerAccount.from(player);
	}

	private String requireField(String value, String field) {
		if (value == null || value.isBlank()) {
			throw new InvalidPlayerRequestException(field);
		}
		return value;
	}
}
