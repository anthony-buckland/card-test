package za.co.aboutblank.HandCalculator;

import one.util.streamex.StreamEx;
import za.co.aboutblank.enums.ScoresEnum;
import za.co.aboutblank.exceptions.InvalidCardException;
import za.co.aboutblank.helpers.CardOrderCheck;
import za.co.aboutblank.helpers.ReverseOrderedCardComparator;
import za.co.aboutblank.interfaces.HandCalculator;
import za.co.aboutblank.models.Card;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HandCalculatorImpl implements HandCalculator {

    public Boolean isRoyalFlush(List<Card> cards) throws InvalidCardException {
        // Only one suit, contains an ace. It will be ordered with the ace at the end because
        // the default is Aces low. So we need one suit,the first card must be a king.
        cards.sort(new ReverseOrderedCardComparator());
        if (cards.get(0).getScore().getValue() != 13 || cards.get(4).getScore().getValue() != 1) {
            // No King or Ace, return
            return false;
        }

        var suit = cards.get(0).getSuit(); // all need to match
        var hand = cards.stream()
                .filter(c -> c.getSuit() == suit)
                .toList();
        // reduced list of cards. Pop the Ace_Low, push the Ace_High
        var cardsInOrder = new ArrayList<>(cards);
        cardsInOrder.add(0, new Card(suit, ScoresEnum.SCORE_ACES_HIGH));
        cardsInOrder.remove(cardsInOrder.size() - 1);


        if (CardOrderCheck.isReverseConsecutive(cardsInOrder)
                && hand.size() == 5) {
            return true;
        }
        ;
        return false;
    }

    public boolean isFiveOfAKind(List<Card> cards) {
        // Requires a joker. I think you can do it with both jokers? The wiki article does not say
        var hasJoker = cards.stream()
                .filter(Card::isJoker)
                .toList();
        // Let's assume a single pack here, in Las Vegas it is probably possible to get 5 Jokers
        if (hasJoker.size() == 1 || hasJoker.size() == 2) {
            // test the remaining cards by value (the loop is cleaner than a stream,
            // and it only needs to run over 5 cards. I should probably take out the Jokers)
            var duplicates = countDuplicateScores(cards);
            // Only two unique values should exist, Joker and whatever other value
            return duplicates == 2;
        }
        return false;
    }

    public boolean isStraightFlush(List<Card> cards) {
        // Check the first card suit, all the others need to match it
        // Sort the cards, check if there are in (reverse) sequential order.
        // Not sure if the Jokers are allowed, so will not include them
        cards.sort(new ReverseOrderedCardComparator());
        var suit = cards.get(0).getSuit(); // all need to match
        var hand = cards.stream()
                .filter(c -> c.getSuit() == suit)
                .toList();
        //A bit of a hack here. The code can return the wrong value for a Straight Flush and a flush,
        // so we want  to know that the cards are consecutive
        if (!(CardOrderCheck.isReverseConsecutive(cards) && hand.size() == 5)) {
            return false;
        }
        ;
        return true;
    }

    public boolean isFourOfAKind(List<Card> cards) {
        // there should be only four equal scored cards, assuming a
        // single pack, thus only two possible card scores
        cards.sort(new ReverseOrderedCardComparator());
        var hand = StreamEx.of(cards)
                .distinct(Card::getScore)
                .toList();

        return hand.size() == 2
                && cards.get(0).getScore() == cards.get(3).getScore();
    }

    public boolean isFullHouse(List<Card> cards) {
        // We want to get two lists, one with three matching scores,
        // and one with two matching scores
        cards.sort(new ReverseOrderedCardComparator());
        var upperCard = cards.get(0).getScore();
        var lowerCard = cards.get(4).getScore();
        var upper = cards.stream()
                .filter(c -> c.getScore() == upperCard)
                .toList();
        var lower = cards.stream()
                .filter(c -> c.getScore() == lowerCard)
                .toList();

        return lower.size() == 3 && upper.size() == 2
                || lower.size() == 2 && upper.size() == 3;
    }

    public boolean isFlush(List<Card> cards) {
        // all cards the same suit. No order, though I decided to order
        // the list anyway. Maybe someone one day might like to know the
        // highest card. It apparently matters.
        cards.sort(new ReverseOrderedCardComparator());
        var duplicates = countDuplicateSuits(cards);

        return duplicates == 1;
    }

    public boolean isStraight(List<Card> cards) {
        // 5 Sequential cards of any suit.
        // Sort the cards in (reverse) sequential order.
        cards.sort(new ReverseOrderedCardComparator());
        return CardOrderCheck.isReverseConsecutive(cards);
    }

    public boolean isThreeOfAKind(List<Card> cards) {
        // Again, assuming a single pack of cards. And this code
        // is executed in order
        cards.sort(new ReverseOrderedCardComparator());
        var hand = StreamEx.of(cards)
                .distinct(Card::getScore)
                .toList();
        return hand.size() == 3
                && cards.get(0).getScore() == cards.get(2).getScore();
    }

    public boolean isTwoPair(List<Card> cards) {
        // we expect precisely 3 suits, the pairs and the random extra
        cards.sort(new ReverseOrderedCardComparator());
        var hand = StreamEx.of(cards)
                .distinct(Card::getScore)
                .toList();
        return hand.size() == 3
                && cards.get(0) != cards.get(3)
                && cards.get(3) != cards.get(4);
    }

    public boolean isOnePair(List<Card> cards) {
        // Note that this can produce false positives if it is not executed
        // in the strict order of the methods as listed in this class, specifically
        // a double pair
        var duplicates = countDuplicateScores(cards);
        // we expect 2 or 3 suits - 1 of the pair, and either 1 or 2 extras
        return duplicates == 4;
    }

    public boolean isHighCard(List<Card> cards) {
        // At this point, we've tested for every other winning scenario
        // if you don't have the highest card, it's time to leave the casino.
        return true;
    }

    private int countDuplicateScores(List<Card> cards) {

        var seen = new HashSet<>();
        var duplicates = new HashSet<>();
        for (Card c : cards) {
            if (seen.add(c.getScore())) {
                duplicates.add(c.getScore());
            }
        }
        return duplicates.size();
    }

    private int countDuplicateSuits(List<Card> cards) {

        var seen = new HashSet<>();
        var duplicates = new HashSet<>();
        for (Card c : cards) {
            if (seen.add(c.getSuit())) {
                duplicates.add(c.getSuit());
            }
        }
        return duplicates.size();
    }
}
