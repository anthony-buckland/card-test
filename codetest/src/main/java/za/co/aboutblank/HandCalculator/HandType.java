package za.co.aboutblank.HandCalculator;

import za.co.aboutblank.consts.Words;
import za.co.aboutblank.exceptions.InvalidCardException;
import za.co.aboutblank.helpers.ReverseOrderedCardComparator;
import za.co.aboutblank.models.Card;

import java.util.Collections;
import java.util.List;

public class HandType {

    public static String describe(List<Card> cards) throws InvalidCardException {
        var defaultValue = Words.HIGHEST_CARD;
        var calc = new HandCalculatorImpl();
        // go through the cards and test for each condition, in *strict* order.
        //
        // This is messy and should Java ever adopt JavaScripts "switch(true)"
        // I will be forever grateful. Perhaps a rules engine would work better here.
        // but I ran out of time to implement one.
        if (calc.isRoyalFlush(cards)) {
            return Words.ROYAL_FLUSH;
        } else if (calc.isFiveOfAKind(cards)) {
            return Words.FIVE_OF_KIND;
        } else if (calc.isStraightFlush(cards)) {
            return Words.STRAIGHT_FLUSH;
        } else if (calc.isFourOfAKind(cards)) {
            return Words.FOUR_OF_KIND;
        } else if (calc.isFullHouse(cards)) {
            return Words.FULL_HOUSE;
        } else if (calc.isFlush(cards)) {
            return Words.FLUSH;
        } else if (calc.isStraight(cards)) {
            return Words.STRAIGHT;
        } else if (calc.isThreeOfAKind(cards)) {
            return Words.THREE_OF_KIND;
        } else if (calc.isTwoPair(cards)) {
            return Words.TWO_PAIRS;
        } else if (calc.isOnePair(cards)) {
            return Words.ONE_PAIR;
        }
        // if all else fails... highest card
        return defaultValue;
    }
}
