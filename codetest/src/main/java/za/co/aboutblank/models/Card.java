package za.co.aboutblank.models;

import za.co.aboutblank.enums.ScoresEnum;
import za.co.aboutblank.enums.SuitsEnum;
import za.co.aboutblank.exceptions.InvalidCardException;

import static za.co.aboutblank.consts.Errors.*;

public class Card {

    private SuitsEnum suit = null;
    private ScoresEnum score = null;

    public SuitsEnum getSuit() {
        return suit;
    }

    public ScoresEnum getScore() {
        return score;
    }

    public boolean isJoker() {
        return suit.isJoker();
    }

    public Card(SuitsEnum suit, ScoresEnum score) throws InvalidCardException {
        this.suit = suit;
        this.score = score;
        // Test for suit
        if (suit == null) {
            throw new InvalidCardException(NO_SUIT);
        }
        // test for Joker
        if (suit.isJoker() && score != ScoresEnum.SCORE_JOKER) {
            throw new InvalidCardException(NO_SCORE_FOR_JOKER);
        }
        // test for illegal scores
        if (!suit.isJoker() && score.getValue() > 14) {
            throw new InvalidCardException(SCORE_OVER_LIMITS);
        }
    }
}

