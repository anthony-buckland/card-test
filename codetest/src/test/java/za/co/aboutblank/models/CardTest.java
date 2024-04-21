package za.co.aboutblank.models;

import org.junit.jupiter.api.Test;
import za.co.aboutblank.enums.ScoresEnum;
import za.co.aboutblank.enums.SuitsEnum;
import za.co.aboutblank.exceptions.InvalidCardException;

import static org.junit.jupiter.api.Assertions.*;
import static za.co.aboutblank.consts.Errors.NO_SUIT;
import static za.co.aboutblank.consts.Errors.SCORE_OVER_LIMITS;

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


}
