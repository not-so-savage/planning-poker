package uk.co.gamma.scrumpoker.simulator;

import java.util.ArrayList;
import java.util.List;

import uk.co.gamma.scrumpoker.domain.Developer;
import uk.co.gamma.scrumpoker.domain.PokerDeck;
import uk.co.gamma.scrumpoker.domain.Ticket;
import uk.co.gamma.scrumpoker.domain.Vote;
import uk.co.gamma.scrumpoker.generator.VoteGenerator;

public class Poker {

	private VoteGenerator voteGenerator;
	private List<Developer> developers;
	private PokerDeck deck;

	public Poker(List<Developer> developers, PokerDeck deck) {
		this.developers = developers;
		this.deck = deck;
	}

	public void play(List<Ticket> tickets) {
		// TODO: Q3. Simulate a scrum poker session
	}

	public void setVoteGenerator(VoteGenerator voteGenerator) {
		this.voteGenerator = voteGenerator;
	}
}