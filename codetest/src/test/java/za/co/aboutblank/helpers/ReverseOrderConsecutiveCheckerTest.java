package za.co.aboutblank.helpers;

import org.junit.jupiter.api.Test;
import za.co.aboutblank.enums.ScoresEnum;
import za.co.aboutblank.enums.SuitsEnum;
import za.co.aboutblank.exceptions.InvalidCardException;
import za.co.aboutblank.models.Card;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReverseOrderConsecutiveCheckerTest {

    @Test
    public void canCheckReversedConsecutiveCardOrder() throws InvalidCardException {

        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_7),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_10),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_9),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_8),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_JACK)
        );

        cards.sort(new ReverseOrderedCardComparator());

        assertEquals(ScoresEnum.SCORE_JACK.getValue(), cards.get(0).getScore().getValue());
        assertEquals(ScoresEnum.SCORE_10.getValue(), cards.get(1).getScore().getValue());
        assertEquals(ScoresEnum.SCORE_9.getValue(), cards.get(2).getScore().getValue());
        assertEquals(ScoresEnum.SCORE_8.getValue(), cards.get(3).getScore().getValue());
        assertEquals(ScoresEnum.SCORE_7.getValue(), cards.get(4).getScore().getValue());

        // Test if they are in consecutive order
        assertTrue(CardOrderCheck.isReverseConsecutive(cards));

    }

}