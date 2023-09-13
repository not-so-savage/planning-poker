package uk.co.gamma.scrumpoker;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import uk.co.gamma.scrumpoker.domain.Ticket;
import uk.co.gamma.scrumpoker.domain.Developer;
import uk.co.gamma.scrumpoker.domain.PokerDeck;
import uk.co.gamma.scrumpoker.domain.PokerDeckCard;
import uk.co.gamma.scrumpoker.generator.CardValuesGenerator;
import uk.co.gamma.scrumpoker.generator.FibonacciCardValuesGenerator;
import uk.co.gamma.scrumpoker.generator.RandomVoteGenerator;
import uk.co.gamma.scrumpoker.simulator.Poker;

public class Main {

	public static void main(String[] args) {

		List<Developer> developers = initDevelopers();

		Poker poker = initPoker(7, developers);

		List<Ticket> tickets = initTickets();

		poker.play(tickets);

		generateJson(tickets);
	}

	private static Poker initPoker(int numberOfCards, List<Developer> developers) {

		CardValuesGenerator cardValuesGenerator = new FibonacciCardValuesGenerator(numberOfCards);
		List<Integer> cardValues = cardValuesGenerator.generateValues();

		List<PokerDeckCard> cards = initCards(cardValues);

		PokerDeck deck = new PokerDeck(cards);

		Poker poker = new Poker(developers, deck);

		poker.setVoteGenerator(new RandomVoteGenerator());

		return poker;
	}

	private static List<PokerDeckCard> initCards(List<Integer> values) {
		return values.stream()
				.map(PokerDeckCard::new)
				.collect(toList());
	}

	private static List<Developer> initDevelopers() {
        return Arrays.asList(
				new Developer("Alice"),
				new Developer("John"),
				new Developer("Steph"),
				new Developer("Henry")
		);
	}

	private static List<Ticket> initTickets() {
		return null; // TODO
	}

	private static void generateJson(List<Ticket> tickets) {

		String report = null; // TODO
	}
}