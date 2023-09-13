package uk.co.gamma.scrumpoker.simulator;

import org.junit.jupiter.api.Test;
import uk.co.gamma.scrumpoker.domain.*;
import uk.co.gamma.scrumpoker.generator.RandomVoteGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PokerTest {
    @Test
    void votingOnTicketSetsTicketPoints() {
        List<Developer> developers = Arrays.asList(
                new Developer("John"),
                new Developer("Sophie"),
                new Developer("Liam")
        );

        PokerDeck deck = new PokerDeck(
                Arrays.asList(
                        new PokerDeckCard(1),
                        new PokerDeckCard(4),
                        new PokerDeckCard(7)
                )
        );

        Poker poker = new Poker(developers, deck);
        poker.setVoteGenerator(new RandomVoteGenerator());

        List<Ticket> tickets = List.of(
                Ticket.createTask("test-ticket", developers.get(0), Priority.MINOR)
        );

        poker.play(tickets);

        assertThat(tickets.get(0).getPoints()).isGreaterThan(0);
    }
}