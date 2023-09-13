package uk.co.gamma.scrumpoker.simulator;

import java.util.List;
import uk.co.gamma.scrumpoker.domain.Ticket;
import uk.co.gamma.scrumpoker.generator.VoteGenerator;

public class Poker {

	private VoteGenerator voteGenerator;

	public void play(List<Ticket> tickets) {
		// TODO: Q3. Simulate a scrum poker session
	}

	// TODO: Q2. Create a method to simulate voting for a single ticket

	public void setVoteGenerator(VoteGenerator voteGenerator) {
		this.voteGenerator = voteGenerator;
	}
}