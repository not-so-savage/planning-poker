package uk.co.gamma.scrumpoker.domain;

import java.util.List;

public class PokerDeck {
    private final List<PokerDeckCard> cards;

    public PokerDeck(List<PokerDeckCard> cards) {
        this.cards = cards;
    }
}
