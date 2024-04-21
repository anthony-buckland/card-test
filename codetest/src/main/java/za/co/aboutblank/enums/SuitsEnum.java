package za.co.aboutblank.enums;

import java.util.Arrays;
import java.util.Optional;

public enum SuitsEnum {
    HEARTS("H"),
    CLUBS("C"),
    DIAMONDS("D"),
    SPADES("S"),
    JOKER("J");

    public boolean isJoker() {
        return this == JOKER;
    }

    private String suit;

    SuitsEnum(String suit) {
        this.suit = suit;
    }

    public static Optional<SuitsEnum> get(String abbreviatedSuit) {
        return Arrays.stream(SuitsEnum.values())
                .filter(suits -> suits.suit.equals(abbreviatedSuit))
                .findFirst();
    }
}
