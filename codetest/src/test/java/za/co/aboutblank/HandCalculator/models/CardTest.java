package za.co.aboutblank.HandCalculator.models;

import org.junit.jupiter.api.Test;
import za.co.aboutblank.enums.AcesEnum;
import za.co.aboutblank.enums.ScoresEnum;
import za.co.aboutblank.enums.SuitsEnum;
import za.co.aboutblank.exceptions.InvalidCardException;
import za.co.aboutblank.models.Card;

import static org.junit.jupiter.api.Assertions.*;
import static za.co.aboutblank.consts.Errors.*;

public class CardTest {

    @Test
    public void isNullSuit() {
        var ex = assertThrows(
                InvalidCardException.class,
                () -> new Card(null, ScoresEnum.SCORE_2),
                "isNullSuit failed!");

        assertTrue(ex.getMessage().contains(NO_SUIT));
    }

    @Test
    public void isInvalidScore() {
        var ex = assertThrows(
                InvalidCardException.class,
                () -> new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_JOKER),
                "isInvalidScore failed!");

        assertTrue(ex.getMessage().contains(SCORE_OVER_LIMITS));
    }

    @Test
    public void getScore() throws InvalidCardException {
        var card = new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_2);

        assertEquals(2, card.getScore().getValue());
    }

    @Test
    public void getScoreForAnAcesLow() throws InvalidCardException {
        // Test doesn't do very much!
        var card = new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_ACES_LOW);
        assertEquals(1, card.getScore().getValue());
    }

    @Test
    public void getScoreForAnAcesHigh() throws InvalidCardException {
        // Nor this one.
        var card = new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_ACES_HIGH);
        assertEquals(14, card.getAceScore(AcesEnum.HIGH));
    }

    @Test
    public void getScoreForAnythingExceptAce() throws InvalidCardException {
        var card = new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_8);
        assertEquals(8, card.getAceScore(AcesEnum.HIGH));
    }
}
