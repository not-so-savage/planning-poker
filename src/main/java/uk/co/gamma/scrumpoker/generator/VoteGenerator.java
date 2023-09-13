package uk.co.gamma.scrumpoker.generator;

import java.util.List;
import uk.co.gamma.scrumpoker.domain.Ticket;
import uk.co.gamma.scrumpoker.domain.Developer;
import uk.co.gamma.scrumpoker.domain.PokerDeck;
import uk.co.gamma.scrumpoker.domain.Vote;

/**
 * Implementations of this interface are responsible for
 * getting votes off developers for a ticket *
 */
public interface VoteGenerator {
	List<Vote> getVotes(Ticket ticket, PokerDeck pokerDeck, List<Developer> developers);
}
