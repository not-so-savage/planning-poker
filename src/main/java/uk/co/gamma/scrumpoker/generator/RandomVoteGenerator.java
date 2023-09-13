package uk.co.gamma.scrumpoker.generator;

import java.util.List;
import java.util.stream.Collectors;
import uk.co.gamma.scrumpoker.domain.Ticket;
import uk.co.gamma.scrumpoker.domain.Developer;
import uk.co.gamma.scrumpoker.domain.PokerDeck;
import uk.co.gamma.scrumpoker.domain.Vote;

public class RandomVoteGenerator implements VoteGenerator {

	@Override
	public List<Vote> getVotes(Ticket ticket, PokerDeck pokerDeck, List<Developer> developers) {
		// TODO: Q2. Generate random votes for each developer
        return null;
    }
}