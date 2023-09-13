package uk.co.gamma.scrumpoker.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PokerDeckTest {

    @Test
    void getRandomCardWithinDeck() {
        List<Integer> possibleCardValues = List.of(1, 2, 3);

        PokerDeck deck = new PokerDeck(
                Arrays.asList(
                        new PokerDeckCard(possibleCardValues.get(0)),
                        new PokerDeckCard(possibleCardValues.get(1)),
                        new PokerDeckCard(possibleCardValues.get(2))
                )
        );

        // I don't like that the data in this test will change, but I suppose that's the nature of generating a random number.
        PokerDeckCard selectedCard = deck.getRandomCard();

        assertThat(possibleCardValues).contains(selectedCard.getValue());
    }
}