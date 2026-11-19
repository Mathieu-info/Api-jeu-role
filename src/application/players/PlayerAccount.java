package application.players;

import players.Player;

public record PlayerAccount(String id, String pseudonym, String email) {

	public static PlayerAccount from(Player player) {
		return new PlayerAccount(
			player.getId().value(),
			player.getPseudonym().value(),
			player.getEmail().value()
		);
	}
}
