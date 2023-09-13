package uk.co.gamma.scrumpoker.domain;

import java.util.List;
import java.util.Random;

public class PokerDeck {
    private final List<PokerDeckCard> cards;

    public PokerDeck(List<PokerDeckCard> cards) {
        this.cards = cards;
    }

    public PokerDeckCard getRandomCard() {
        Random rand = new Random();
        return cards.get(rand.nextInt(cards.size()));
    }
}
