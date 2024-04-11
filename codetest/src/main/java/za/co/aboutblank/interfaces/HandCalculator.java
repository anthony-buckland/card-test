package za.co.aboutblank.interfaces;

import za.co.aboutblank.models.Card;

import java.util.List;

// Normally, I'd avoid an interface where only a single class
// implements it, modern unit testing tools can use concrete
// classes.

public interface HandCalculator {
    boolean isFourOfAKind(List<Card> cards);

    boolean isFiveOfAKind(List<Card> cards);

    boolean isFullHouse(List<Card> cards);

    boolean isFlush(List<Card> cards);

    boolean isStraight(List<Card> cards);

    boolean isThreeOfAKind(List<Card> cards);

    boolean isTwoPair(List<Card> cards);

    boolean isOnePair(List<Card> cards);

    boolean isHighCard(List<Card> cards);
}
