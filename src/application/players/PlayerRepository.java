package application.players;

import java.util.Optional;
import players.Email;
import players.Player;
import players.PlayerId;
import players.Pseudonym;

public interface PlayerRepository {

	Optional<Player> findById(PlayerId id);

	Optional<Player> findByPseudonym(Pseudonym pseudonym);

	Optional<Player> findByEmail(Email email);

	void save(Player player);
}
