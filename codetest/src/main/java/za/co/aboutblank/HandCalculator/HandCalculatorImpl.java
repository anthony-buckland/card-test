package za.co.aboutblank.HandCalculator;

import za.co.aboutblank.helpers.CardOrderCheck;
import za.co.aboutblank.helpers.ReverseOrderedCardComparator;
import za.co.aboutblank.interfaces.HandCalculator;
import za.co.aboutblank.models.Card;

import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

public class HandCalculatorImpl implements HandCalculator {

    public boolean isFiveOfAKind(List<Card> cards) {
        // Requires a joker. I think you can do it with both jokers?
        var hasJoker = cards.stream()
                .filter(Card::isJoker)
                .toList();
        // Lets assume a single pack here, in Las Vegas it is probably possible to get 5 Jokers
        if (hasJoker.size() == 1 || hasJoker.size() == 2) {
            // test the remaining cards by value (the loop is cleaner than a stream,
            // and it only needs to run over 5 cards. I should probably taken out the Jokers)
            // TODO - take the jokers out the List for max efficiency!
            var seen = new HashSet<>();
            var duplicates = new HashSet<>();
            for (Card c : cards) {
                if (seen.add(c.getScore())) {
                    duplicates.add(c.getScore());
                }
            }
            // Only two unique values should exist, Joker and whatever other value
            return duplicates.size() == 2;
        }
        return false;
    }

    public boolean isStraightFlush(List<Card> cards) {
        // Check the first card suit, all the others need to match it
        // Sort the cards, check if there are in (reverse) sequential order.
        // Not sure if the Jokers are allowed, so will not include them
        var suit = cards.get(0).getSuit();

        cards.sort(new ReverseOrderedCardComparator());
        var hand = cards.stream()
                .filter(c -> c.getSuit() == suit)
                .toList();

        // Fortunately Instream gan also go in reverse!
        var isSequential = IntStream.range(hand.size(), 0)
                .allMatch(value -> {
                    var match = value - 1 == hand.get(value).getScore().getValue();
                    return match;
                });

        return hand.size() == 5 && isSequential;
    }

    public boolean isFourOfAKind(List<Card> cards) {
        // There should be only two suites in our result, the 4 of a kind
        // and something else.

        var seen = new HashSet<>();
        var duplicates = new HashSet<>();
        for (Card c : cards) {
            if (seen.add(c.getScore())) {
                duplicates.add(c.getSuit());
            }
        }

        return duplicates.size() == 2;
    }

    public boolean isFullHouse(List<Card> cards) {
        // We want to get two lists, one with three matching scores,
        // and one with two matching scores
        cards.sort(new ReverseOrderedCardComparator());
        var upperCard = cards.get(0).getScore();
        var lowerCard = cards.get(4).getScore();
        var lower = cards.stream()
                .filter(c -> c.getScore() == lowerCard)
                .toList();
        var upper = cards.stream()
                .filter(c -> c.getScore() == upperCard)
                .toList();

        return lower.size() == 3 && upper.size() == 2;
    }

    public boolean isFlush(List<Card> cards) {
        // all cards the same suit. No order, though I decided to order
        // the list anyway. Maybe someone one day might like to know the
        // highest card. It apparently matters.
        cards.sort(new ReverseOrderedCardComparator());
        var seen = new HashSet<>();
        var duplicates = new HashSet<>();
        for (Card c : cards) {
            if (seen.add(c.getScore())) {
                duplicates.add(c.getSuit());
            }
        }

        return duplicates.size() == 1;
    }

    public boolean isStraight(List<Card> cards) {
        // 5 Sequential cards of any suit.
        // Sort the cards in (reverse) sequential order.
        cards.sort(new ReverseOrderedCardComparator());
        var isConsecutive = CardOrderCheck.isReverseConsecutive(cards);

        return cards.size() == 5 && isConsecutive;
    }

    public boolean isThreeOfAKind(List<Card> cards) {
        // This is basically a copy of earlier code
        //TODO refactor into one method if possible
        return false;
        // isSequential
    }

    public boolean isTwoPair(List<Card> cards) {
        // This is basically a copy of earlier code
        //TODO refactor into one method if possible
        return false;
    }

    public boolean isOnePair(List<Card> cards) {

        return false;
    }

    public boolean isHighCard(List<Card> cards) {

        return false;
    }
}
