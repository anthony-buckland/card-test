package za.co.aboutblank.enums;


import org.junit.jupiter.api.Test;
import za.co.aboutblank.exceptions.InvalidCardException;
import za.co.aboutblank.models.Card;

import static org.junit.jupiter.api.Assertions.*;


public class SuitsEnumTest {

    @Test
    void isJokerTest() throws InvalidCardException {
        var card = new Card(SuitsEnum.JOKER, ScoresEnum.SCORE_JOKER);
        assertTrue(card.isJoker());
    }

    @Test
    void isNotJokerTest() throws InvalidCardException {
        var card = new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_10);
        assertFalse(card.isJoker());
    }

    @Test
    void getSuit() {
        var abbreviated = "D";
        assertEquals(SuitsEnum.DIAMONDS, SuitsEnum.get(abbreviated).get());
    }

    @Test
    void getSuitFails() {
        var abbreviated = "D";
        assertNotEquals(SuitsEnum.HEARTS, SuitsEnum.get(abbreviated).get());
    }
}


