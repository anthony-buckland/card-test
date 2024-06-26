package za.co.aboutblank.HandCalculator;

import org.junit.jupiter.api.Test;
import za.co.aboutblank.enums.ScoresEnum;
import za.co.aboutblank.enums.SuitsEnum;
import za.co.aboutblank.exceptions.InvalidCardException;
import za.co.aboutblank.models.Card;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HandTypeCalculatorImplTest {

    HandCalculatorImpl sut = new HandCalculatorImpl();

    @Test
    public void isRoyalFlushTest() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_KING),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_QUEEN),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_JACK),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_10),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_ACES_LOW)
        );
        assertTrue(sut.isRoyalFlush(cards));
    }

    @Test
    public void isRoyalFlushUnordered() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_ACES_LOW),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_QUEEN),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_JACK),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_KING),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_10)

        );
        assertTrue(sut.isRoyalFlush(cards));
    }

    @Test
    public void isRoyalFlushBadCard() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_ACES_LOW),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_QUEEN),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_JACK),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_KING),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_10)

        );
        assertFalse(sut.isRoyalFlush(cards));
    }


    @Test
    public void is5ofKindTest() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.CLUBS, ScoresEnum.SCORE_2),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_2),
                new Card(SuitsEnum.SPADES, ScoresEnum.SCORE_2),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_2),
                new Card(SuitsEnum.JOKER, ScoresEnum.SCORE_JOKER)
        );

        assertTrue(sut.isFiveOfAKind(cards));

    }

    @Test
    public void is5ofKindTestWithOneJokersSadPath() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_2),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_3),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_4),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_5),
                new Card(SuitsEnum.JOKER, ScoresEnum.SCORE_JOKER)
        );

        assertFalse(sut.isFiveOfAKind(cards));
    }

    @Test
    public void is5ofKindTestWithTwoJokers() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.CLUBS, ScoresEnum.SCORE_2),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_2),
                new Card(SuitsEnum.JOKER, ScoresEnum.SCORE_JOKER),
                new Card(SuitsEnum.SPADES, ScoresEnum.SCORE_2),
                new Card(SuitsEnum.JOKER, ScoresEnum.SCORE_JOKER)
        );

        assertTrue(sut.isFiveOfAKind(cards));

    }

    @Test
    public void is5ofKindSadPathTest() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.CLUBS, ScoresEnum.SCORE_2),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_2),
                new Card(SuitsEnum.SPADES, ScoresEnum.SCORE_2),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_2),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_8)
        );

        assertFalse(sut.isFiveOfAKind(cards));

    }

    // Straight Flush -------------------------------------------
    @Test
    public void isStraightFlushTest() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_7),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_10),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_9),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_8),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_JACK)

        );

        assertTrue(sut.isStraightFlush(cards));

    }

    @Test
    public void isStraightFlushDifferentSuit() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_7),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_10),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_9),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_8),
                new Card(SuitsEnum.CLUBS, ScoresEnum.SCORE_JACK)
        );

        assertFalse(sut.isStraightFlush(cards));

    }

    @Test
    public void isStraightNonSequential() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_2),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_10),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_9),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_8),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_JACK)
        );

        assertFalse(sut.isStraight(cards));

    }

    @Test
    public void isFourOfAKindTest() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.CLUBS, ScoresEnum.SCORE_5),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_5),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_5),
                new Card(SuitsEnum.SPADES, ScoresEnum.SCORE_5),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_2)
        );
        assertTrue(sut.isFourOfAKind(cards));
    }

    @Test
    public void isFourOfAKindFailureTest() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.CLUBS, ScoresEnum.SCORE_7),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_10),
                new Card(SuitsEnum.CLUBS, ScoresEnum.SCORE_JACK),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_9),
                new Card(SuitsEnum.SPADES, ScoresEnum.SCORE_8)
        );
        assertFalse(sut.isFourOfAKind(cards));
    }

    @Test
    public void isFullHouseTest() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_KING),
                new Card(SuitsEnum.CLUBS, ScoresEnum.SCORE_6),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_6),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_6),
                new Card(SuitsEnum.SPADES, ScoresEnum.SCORE_KING)
        );
        assertTrue(sut.isFullHouse(cards));
    }

    @Test
    public void isFullHouseSadPathTest() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_KING),
                new Card(SuitsEnum.CLUBS, ScoresEnum.SCORE_6),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_6),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_7),
                new Card(SuitsEnum.SPADES, ScoresEnum.SCORE_KING)
        );
        assertFalse(sut.isFullHouse(cards));
    }

    // Flush -----------------------------------------------------
    @Test
    public void isFlushTest() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_JACK),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_6),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_3),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_7),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_KING)
        );
        assertTrue(sut.isFlush(cards));
    }

    @Test
    public void isFlushTestSadPath() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_JACK),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_6),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_3),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_7),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_KING)
        );
        assertFalse(sut.isFlush(cards));
    }

    // Straight ------------------------------------------------------

    @Test
    public void isStraightTest() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_10),
                new Card(SuitsEnum.SPADES, ScoresEnum.SCORE_9),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_8),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_7),
                new Card(SuitsEnum.CLUBS, ScoresEnum.SCORE_6)
        );
        assertTrue(sut.isStraight(cards));
    }

    @Test
    public void isStraightSadPathTest() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_JACK),
                new Card(SuitsEnum.CLUBS, ScoresEnum.SCORE_6),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_3),
                new Card(SuitsEnum.CLUBS, ScoresEnum.SCORE_7),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_KING)

        );
        assertFalse(sut.isStraight(cards));
    }

    // 3 of a kind --------------------------------------------------
    @Test
    public void isThreeOfAKindTest() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_QUEEN),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_6),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_3),
                new Card(SuitsEnum.CLUBS, ScoresEnum.SCORE_QUEEN),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_QUEEN)
        );
        assertTrue(sut.isThreeOfAKind(cards));
    }

    @Test
    public void isThreeOfAKindFailedTest() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_JACK),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_6),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_3),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_7),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_KING)
        );
        assertFalse(sut.isThreeOfAKind(cards));
    }

    @Test
    public void isTwoPairTest() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_JACK),
                new Card(SuitsEnum.SPADES, ScoresEnum.SCORE_JACK),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_3),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_3),
                new Card(SuitsEnum.SPADES, ScoresEnum.SCORE_2)
        );
        assertTrue(sut.isTwoPair(cards));
    }

    @Test
    public void isTwoPairSadPathTest() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_JACK),
                new Card(SuitsEnum.SPADES, ScoresEnum.SCORE_QUEEN),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_3),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_3),
                new Card(SuitsEnum.SPADES, ScoresEnum.SCORE_2)
        );
        assertFalse(sut.isTwoPair(cards));
    }

    @Test
    public void isTwoPairInvalidUseTest() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_JACK),
                new Card(SuitsEnum.SPADES, ScoresEnum.SCORE_JACK),
                new Card(SuitsEnum.CLUBS, ScoresEnum.SCORE_JACK),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_JACK),
                new Card(SuitsEnum.SPADES, ScoresEnum.SCORE_2)
        );
        assertFalse(sut.isTwoPair(cards));
    }

    @Test
    public void isOnePairTest() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_JACK),
                new Card(SuitsEnum.SPADES, ScoresEnum.SCORE_QUEEN),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_3),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_3),
                new Card(SuitsEnum.SPADES, ScoresEnum.SCORE_2)
        );
        assertTrue(sut.isOnePair(cards));

    }

    @Test
    public void isOnePairSadPathTest() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_JACK),
                new Card(SuitsEnum.SPADES, ScoresEnum.SCORE_QUEEN),
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_3),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_3),
                new Card(SuitsEnum.SPADES, ScoresEnum.SCORE_2)
        );
        assertFalse(sut.isTwoPair(cards));
    }

    @Test
    public void isOnePairInvalidUseTest() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
                new Card(SuitsEnum.HEARTS, ScoresEnum.SCORE_JACK),
                new Card(SuitsEnum.SPADES, ScoresEnum.SCORE_JACK),
                new Card(SuitsEnum.CLUBS, ScoresEnum.SCORE_JACK),
                new Card(SuitsEnum.DIAMONDS, ScoresEnum.SCORE_JACK),
                new Card(SuitsEnum.SPADES, ScoresEnum.SCORE_2)
        );
        assertFalse(sut.isTwoPair(cards));
    }
}
