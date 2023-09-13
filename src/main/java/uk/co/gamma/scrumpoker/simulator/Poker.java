package uk.co.gamma.scrumpoker.simulator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import uk.co.gamma.scrumpoker.domain.Developer;
import uk.co.gamma.scrumpoker.domain.PokerDeck;
import uk.co.gamma.scrumpoker.domain.Ticket;
import uk.co.gamma.scrumpoker.domain.Vote;
import uk.co.gamma.scrumpoker.generator.VoteGenerator;

public class Poker {

    private VoteGenerator voteGenerator;
    private final List<Developer> developers;
    private final PokerDeck deck;

    private static final Integer VOTING_ROUNDS = 4;

    public Poker(List<Developer> developers, PokerDeck deck) {
        this.developers = developers;
        this.deck = deck;
    }

    public void play(List<Ticket> tickets) {
        tickets.forEach(this::voteOnTicket);
    }

    public void setVoteGenerator(VoteGenerator voteGenerator) {
        this.voteGenerator = voteGenerator;
    }

    private void voteOnTicket(Ticket ticket) {
        // TODO refactor this!
        List<Vote> cumulativeVotes = new ArrayList<>();

        for (int i = 0; i < VOTING_ROUNDS; i++) {
            List<Vote> thisRoundsVotes = voteGenerator.getVotes(ticket, deck, developers);

            if (isVoteUnanimous(thisRoundsVotes)) {
                ticket.setPoints(thisRoundsVotes.get(0).getPoints());
                return;
            }

            cumulativeVotes.addAll(thisRoundsVotes);
        }

        Integer selectedVote = calculateSelectedVoteFromAverage(cumulativeVotes);

        ticket.setPoints(selectedVote);
    }

    private Integer calculateSelectedVoteFromAverage(List<Vote> cumulativeVotes) {
        AtomicInteger runningTotal = new AtomicInteger();
        AtomicReference<Integer> count = new AtomicReference<>(0);

        cumulativeVotes.forEach(vote -> {
            runningTotal.addAndGet(vote.getPoints());
            count.getAndSet(count.get() + 1);
        });

        Integer meanAverage = runningTotal.get() / count.get();

        return findScoreClosestToAverage(deck, meanAverage);
    }

    private int findScoreClosestToAverage(PokerDeck deck, Integer mean)
    {
        List<Integer> deckValues = deck.getDeckValues();
        int n = deckValues.size();
        int left = 0, right = n - 1;
        while (left < right) {
            if (Math.abs(deckValues.get(left) - mean)
                    <= Math.abs(deckValues.get(right) - mean)) {
                right--;
            }
            else {
                left++;
            }
        }
        return deckValues.get(left);
    }

    private boolean isVoteUnanimous(List<Vote> votes) {
        return votes.stream()
                .distinct()
                .count() <= 1;
    }
}