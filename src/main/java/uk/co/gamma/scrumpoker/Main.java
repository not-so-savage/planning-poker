package uk.co.gamma.scrumpoker;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import uk.co.gamma.scrumpoker.domain.Ticket;
import uk.co.gamma.scrumpoker.domain.Developer;
import uk.co.gamma.scrumpoker.domain.PokerDeck;
import uk.co.gamma.scrumpoker.domain.PokerDeckCard;
import uk.co.gamma.scrumpoker.domain.generator.RandomVoteGenerator;
import uk.co.gamma.scrumpoker.domain.simulator.Poker;

public class Main {

	public static void main(String[] args) {

		List<Developer> developers = initDevelopers();

		Poker poker = initPoker(7, developers);

		List<Ticket> tickets = initTickets();

		poker.play(tickets);

		generateJson(tickets);
	}

	private static Poker initPoker(int numberOfCards, List<Developer> developers) {

		List<Integer> values = ...

		List<PokerDeckCard> cards = ...

		PokerDeck deck = ...

		Poker poker = ...

		poker.setVoteGenerator(new RandomVoteGenerator());

		return poker;
	}

	private static List<Developer> initDevelopers() {

	}

	private static List<Ticket> initTickets() {

	}

	private static void generateJson(List<Ticket> tickets) {

		String report = ...
	}
}