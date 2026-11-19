package infrastructure.players;

import application.players.PlayerRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import players.Email;
import players.Player;
import players.Pseudonym;

public class InMemoryPlayerRepository implements PlayerRepository {

	private final Map<String, Player> players = new HashMap<>();

	@Override
	public Optional<Player> findByPseudonym(Pseudonym pseudonym) {
		return players.values()
			.stream()
			.filter(player -> player.getPseudonym().equals(pseudonym))
			.findFirst();
	}

	@Override
	public Optional<Player> findByEmail(Email email) {
		return players.values()
			.stream()
			.filter(player -> player.getEmail().equals(email))
			.findFirst();
	}

	@Override
	public void save(Player player) {
		players.put(player.getId().value(), player);
	}
}
