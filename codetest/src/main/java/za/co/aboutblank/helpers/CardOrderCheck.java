package za.co.aboutblank.helpers;

import za.co.aboutblank.models.Card;

import java.util.List;

public class CardOrderCheck {

    // A little more efficient than a stream, because of the need to use sublists in a stream to get the result
    public static boolean isReverseConsecutive(List<Card> cards) {
        for (int i = 0; i < cards.size() - 1; i++) {
            var higher = cards.get(i).getScore().getValue();
            var lower = (i == (cards.size() - 1) ? 0 : cards.get( i + 1) .getScore().getValue());
            if ((higher - 1) != lower) {
                return false;
            }
        }
        return true;
    }


}
