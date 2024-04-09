package za.co.aboutblank.enums;

import za.co.aboutblank.enums.ScoresEnum;

import java.util.Arrays;

public enum AcesEnum {

    LOW(ScoresEnum.SCORE_ACES_LOW.getValue()),
    HIGH(ScoresEnum.SCORE_ACES_HIGH.getValue());

    private int minScore;
    private int maxScore;
    private int[] Scores;
    private int aceValue;

    private AcesEnum(int value) {
        this.aceValue = value;
        this.minScore = Math.min(2, getAceValue());
        this.maxScore = Math.max(ScoresEnum.SCORE_KING.getValue(), getAceValue());
        // test for where the ace falls (this is a bit complicated) - needs to be high
        // when there is a King involved. Test the suits
        this.Scores = new int[52 / 4];
        for (int i = 0; i < Scores.length; i++)
            Scores[i] = this.minScore + i;
    }

    public int getMaxScore() {
        return maxScore;
    }
    public int getMinScore() {
        return minScore;
    }
    public int getAceValue() {
        return this.aceValue;
    }

    public int[] getScores() {
        return Arrays.copyOf(this.Scores, this.Scores.length);
    }

    AcesEnum(ScoresEnum scoresEnum) {
    }
}
