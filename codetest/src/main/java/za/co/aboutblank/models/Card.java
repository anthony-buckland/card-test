package za.co.aboutblank.models;

import za.co.aboutblank.enums.AcesEnum;
import za.co.aboutblank.enums.ScoresEnum;
import za.co.aboutblank.enums.SuitsEnum;
import za.co.aboutblank.exceptions.InvalidCardException;

import static za.co.aboutblank.consts.Errors.NO_SCORE_FOR_JOKER;
import static za.co.aboutblank.consts.Errors.NO_SUIT;

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
        if (!(suit.isJoker() && score == ScoresEnum.SCORE_JOKER)) {
            throw new InvalidCardException(NO_SCORE_FOR_JOKER);
        }
    }

    // If this an ace, there are two possible Scores, Aces high & Aces low.
    // Need to work out which one applies to the hand. Easiest to do it in maths
    public int getAceScore(AcesEnum ace) {
        if (this.score.getValue() == ScoresEnum.SCORE_ACES_HIGH.getValue()
                || this.score.getValue() == ScoresEnum.SCORE_ACES_LOW.getValue()) {
            return ace.getAceValue();
        }
        return score.getValue();
    }
}

