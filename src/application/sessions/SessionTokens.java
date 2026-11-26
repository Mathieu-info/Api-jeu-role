package application.sessions;

import java.util.Optional;
import players.PlayerId;

public interface SessionTokens {

	String issue(PlayerId playerId);

	Optional<PlayerId> resolve(String token);
}
