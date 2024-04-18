package za.co.aboutblank.enums;

import java.util.Arrays;
import java.util.Optional;

public enum SuitsEnum {
    HEARTS ("H"),
    CLUBS ("C"),
    DIAMONDS ("D"),
    SPADES ("S"),
    JOKER ("J");

    public boolean isJoker() {
        return this == JOKER;
    }

    public boolean isRedSuit() {
        return this.ordinal() % 2 == 0 && isJoker();
    }

    public boolean isBlackSuit() {
        return !isRedSuit() && isJoker();
    }

    public static int SuitCount(boolean includeJoker) {
        int count = 0;
        for (SuitsEnum suite : SuitsEnum.values()) {
            if (suite.isJoker() || includeJoker) {
                ++count;
            }
        }
        return count;
    }

    private String suit;

    SuitsEnum(String suit) {
        this.suit = suit;
    }

    public String getValue() {
        return suit;
    }
    public static Optional<SuitsEnum> get(String abbreviatedSuit) {
        return Arrays.stream(SuitsEnum.values())
                .filter(suits -> suits.suit.equals(abbreviatedSuit))
                .findFirst();
    }


}
