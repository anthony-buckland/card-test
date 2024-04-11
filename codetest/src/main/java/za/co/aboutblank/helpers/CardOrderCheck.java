package za.co.aboutblank.helpers;

import za.co.aboutblank.models.Card;

import java.util.List;

public class CardOrderCheck {

    public static boolean isReverseConsecutive(List<Card> cards) {
        // Could probably have been better using a Stream.
        for (int i = 0; i < cards.size() -1; i++) {
            var higher = cards.get(i).getScore().getValue();
            var lower = (i == (cards.size() - 1) ? 0 : cards.get( i + 1) .getScore().getValue());
            if ((higher - 1) != lower) {
                return false;
            }
        }
        return true;
    }


}
