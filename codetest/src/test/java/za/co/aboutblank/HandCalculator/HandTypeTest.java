package za.co.aboutblank.HandCalculator;

import org.junit.jupiter.api.Test;
import za.co.aboutblank.consts.Words;
import za.co.aboutblank.enums.ScoresEnum;
import za.co.aboutblank.enums.SuitsEnum;
import za.co.aboutblank.exceptions.InvalidCardException;
import za.co.aboutblank.models.Card;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HandTypeTest {
    @Test
    public void isCorrect5KindTextTest() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.CLUBS, ScoresEnum.SCORE_2),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_2),
                new Card(SuitsEnum.SPADES, ScoresEnum.SCORE_2),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_2),
                new Card(SuitsEnum.JOKER, ScoresEnum.SCORE_JOKER)
        );
        {
            assertEquals(Words.FIVE_OF_KIND, HandType.describe(cards));
        }
    }

    @Test
    public void isCorrectStraightFlushTextTest() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_7),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_10),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_9),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_8),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_JACK)
        );
        {
            assertEquals(Words.STRAIGHT_FLUSH, HandType.describe(cards));
        }
    }

    @Test
    public void isCorrect4ofKindTextTest() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.CLUBS, ScoresEnum.SCORE_5),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_5),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_5),
                new Card(SuitsEnum.SPADES, ScoresEnum.SCORE_5),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_2)
        );
        {
            assertEquals(Words.FOUR_OF_KIND, HandType.describe(cards));
        }
    }

    @Test
    public void isCorrect4ofKindTextMixedOrderTest() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.CLUBS, ScoresEnum.SCORE_5),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_2),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_5),
                new Card(SuitsEnum.SPADES, ScoresEnum.SCORE_5),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_5)
        );
        {
            assertEquals(Words.FOUR_OF_KIND, HandType.describe(cards));
        }
    }

    @Test
    public void isCorrectFullHouseTextTest() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_KING),
                new Card(SuitsEnum.CLUBS, ScoresEnum.SCORE_6),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_6),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_6),
                new Card(SuitsEnum.SPADES, ScoresEnum.SCORE_KING)
        );
        {
            assertEquals(Words.FULL_HOUSE, HandType.describe(cards));
        }
    }

    @Test
    public void isCorrectFlushTextTest() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_JACK),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_3),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_9),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_8),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_4)
        );
        {
            assertEquals(Words.FLUSH, HandType.describe(cards));
        }
    }

    @Test
    public void isCorrect3ofKindTextTest() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_QUEEN),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_6),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_3),
                new Card(SuitsEnum.CLUBS, ScoresEnum.SCORE_QUEEN),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_QUEEN)
        );
        {
            assertEquals(Words.THREE_OF_KIND, HandType.describe(cards));
        }
    }
    @Test
    public void isCorrect2PairsTextTest() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_JACK),
                new Card(SuitsEnum.SPADES, ScoresEnum.SCORE_JACK),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_3),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_3),
                new Card(SuitsEnum.SPADES, ScoresEnum.SCORE_2)
        );
        {
            assertEquals(Words.TWO_PAIRS, HandType.describe(cards));
        }
    }

    @Test
    public void isCorrect1PairTextTest() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_JACK),
                new Card(SuitsEnum.SPADES, ScoresEnum.SCORE_JACK),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_3),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_5),
                new Card(SuitsEnum.SPADES, ScoresEnum.SCORE_2)
        );
        {
            assertEquals(Words.ONE_PAIR, HandType.describe(cards));
        }
    }

    @Test
    public void isCorrectHighCardTextTest() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_JACK),
                new Card(SuitsEnum.SPADES, ScoresEnum.SCORE_10),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_3),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_4),
                new Card(SuitsEnum.SPADES, ScoresEnum.SCORE_2)
        );
        {
            assertEquals(Words.HIGHEST_CARD, HandType.describe(cards));
        }
    }

}