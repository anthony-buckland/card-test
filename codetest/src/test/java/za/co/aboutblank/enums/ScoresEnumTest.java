package za.co.aboutblank.enums;

import org.junit.jupiter.api.Test;
import za.co.aboutblank.exceptions.InvalidCardException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ScoresEnumTest {

    @Test
    void getValue() {
        var scoreEnum = ScoresEnum.SCORE_2;
        assertEquals(2, scoreEnum.getValue());
    }

    @Test
    void isPresent() {
        var scoreEnum = ScoresEnum.SCORE_2;
        assertTrue(scoreEnum.isPresent());
    }

    @Test
    void getScores() {

    }

    @Test
    void getEnumByStringValue() throws InvalidCardException {
        var scoreEnum = ScoresEnum.getEnumByStringOrValue("K");
        assertEquals(ScoresEnum.SCORE_KING, scoreEnum);
    }

    @Test
    void getEnumByStringValue2() throws InvalidCardException {
        var scoreEnum = ScoresEnum.getEnumByStringOrValue("10");
        assertEquals(ScoresEnum.SCORE_10, scoreEnum);
    }
}