package za.co.aboutblank.helpers;

import za.co.aboutblank.models.Card;

public class ReverseOrderedCardComparator implements java.util.Comparator<Card> {
    @Override
    public int compare(Card a, Card b) {
        return b.getScore().getValue() - a.getScore().getValue();
    }
}
