package uk.co.gamma.scrumpoker;

import static java.util.stream.Collectors.toList;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import uk.co.gamma.scrumpoker.domain.*;
import uk.co.gamma.scrumpoker.generator.CardValuesGenerator;
import uk.co.gamma.scrumpoker.generator.FibonacciCardValuesGenerator;
import uk.co.gamma.scrumpoker.generator.RandomVoteGenerator;
import uk.co.gamma.scrumpoker.simulator.Poker;

public class Main {

	public static void main(String[] args) {

		List<Developer> developers = initDevelopers();

		Poker poker = initPoker(7, developers);

		List<Ticket> tickets = initTickets(developers);

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

	private static List<Ticket> initTickets(List<Developer> developers) {
		return Arrays.asList(
				Ticket.createBug("gamma-1", developers.get(0), Priority.MAJOR, LocalDateTime.of(2023, 10, 1, 13, 0)),
				Ticket.createBug("gamma-2", developers.get(1), Priority.MAJOR, LocalDateTime.of(2023, 10, 2, 13, 0)),
				Ticket.createBug("gamma-3", developers.get(2), Priority.MAJOR, LocalDateTime.of(2023, 10, 3, 13, 0)),
				Ticket.createFeature("gamma-4", developers.get(3), Priority.MINOR, LocalDateTime.of(2023, 10, 4, 13, 0)),
				Ticket.createFeature("gamma-5", developers.get(0), Priority.MINOR, LocalDateTime.of(2023, 10, 5, 13, 0)),
				Ticket.createFeature("gamma-6", developers.get(1), Priority.MINOR, LocalDateTime.of(2023, 10, 6, 13, 0)),
				Ticket.createTask("gamma-7", developers.get(2), Priority.CRITICAL),
				Ticket.createTask("gamma-8", developers.get(3), Priority.CRITICAL),
				Ticket.createTask("gamma-9", developers.get(0), Priority.CRITICAL),
				Ticket.createTask("gamma-10", developers.get(1), Priority.CRITICAL)
		);
	}

	private static void generateJson(List<Ticket> tickets) {

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try {
			String reportJson = ow.writeValueAsString(tickets);
			FileWriter file = new FileWriter("./poker-report.json");
			file.write(reportJson);
			file.close();
		} catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}