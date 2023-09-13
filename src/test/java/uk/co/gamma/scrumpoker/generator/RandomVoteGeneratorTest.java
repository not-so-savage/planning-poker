package uk.co.gamma.scrumpoker.generator;

import org.junit.jupiter.api.Test;
import uk.co.gamma.scrumpoker.domain.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.co.gamma.scrumpoker.domain.Priority.MAJOR;

class RandomVoteGeneratorTest {
    private static final PokerDeck deck = new PokerDeck(
            Arrays.asList(
                    new PokerDeckCard(1),
                    new PokerDeckCard(2),
                    new PokerDeckCard(3)
            )
    );

    @Test
    void ownerOfTicketDoesNotVote() {
        List<Developer> developers = Arrays.asList(
                new Developer("John"),
                new Developer("Sophie"),
                new Developer("Liam")
        );

        Ticket ticket = Ticket.createTask("task1", developers.get(0), MAJOR);

        RandomVoteGenerator randomVoteGenerator = new RandomVoteGenerator();

        List<Vote> votes = randomVoteGenerator.getVotes(ticket, deck, developers);

        assertThat(votes.size()).isEqualTo(2);
    }
}