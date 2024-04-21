package za.co.aboutblank.HandCalculator;

import za.co.aboutblank.consts.Words;
import za.co.aboutblank.exceptions.InvalidCardException;
import za.co.aboutblank.helpers.ReverseOrderedCardComparator;
import za.co.aboutblank.models.Card;

import java.util.Collections;
import java.util.List;

public class HandType {

    public static String describe(List<Card> cards) throws InvalidCardException {
        var result = Words.HIGHEST_CARD; // default
        var calc = new HandCalculatorImpl();
        Collections.sort(cards, new ReverseOrderedCardComparator());
        // go through the cards and test for each condition, in *strict* order.
        //
        // This is messy and should Java ever adopt JavaScripts "switch(true)"
        // I will be forever grateful. Perhaps a rules engine would work better here
        if (calc.isRoyalFlush(cards)) {
            result = Words.ROYAL_FLUSH;
        } else if (calc.isFiveOfAKind(cards)) {
            result = Words.FIVE_OF_KIND;
        } else if (calc.isStraightFlush(cards)) {
            result = Words.STRAIGHT_FLUSH;
        } else if (calc.isFourOfAKind(cards)) {
            result = Words.FOUR_OF_KIND;
        } else if (calc.isFullHouse(cards)) {
            result = Words.FULL_HOUSE;
        } else if (calc.isFlush(cards)) {
            result = Words.FLUSH;
        } else if (calc.isStraight(cards)) {
            result = Words.STRAIGHT;
        } else if (calc.isThreeOfAKind(cards)) {
            result = Words.THREE_OF_KIND;
        } else if (calc.isTwoPair(cards)) {
            result = Words.TWO_PAIRS;
        } else if (calc.isOnePair(cards)) {
            result = Words.ONE_PAIR;
        }
        // if all else fails... highest card
        return result;
    }
}
