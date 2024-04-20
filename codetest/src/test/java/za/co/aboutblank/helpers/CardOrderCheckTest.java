package za.co.aboutblank.helpers;

import org.junit.jupiter.api.Test;
import za.co.aboutblank.enums.ScoresEnum;
import za.co.aboutblank.enums.SuitsEnum;
import za.co.aboutblank.exceptions.InvalidCardException;
import za.co.aboutblank.models.Card;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardOrderCheckTest {

    @Test
    public void isReverseConsecutive() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_JACK),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_10),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_9),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_8),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_7)
        );

        assertTrue(CardOrderCheck.isReverseConsecutive(cards));

    }

    @Test
    public void isNotReverseConsecutive() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_JACK),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_2),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_4),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_3),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_10)
        );

        assertFalse(CardOrderCheck.isReverseConsecutive(cards));
    }
}