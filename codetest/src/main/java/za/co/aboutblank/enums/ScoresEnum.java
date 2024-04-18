package za.co.aboutblank.enums;

import java.util.Arrays;
import java.util.List;

public enum ScoresEnum {
    SCORE_ACES_LOW(1),
    SCORE_2(2),
    SCORE_3(3),
    SCORE_4(4),
    SCORE_5(5),
    SCORE_6(6),
    SCORE_7(7),
    SCORE_8(8),
    SCORE_9(9),
    SCORE_10(10),
    SCORE_JACK(11),
    SCORE_QUEEN(12),
    SCORE_KING(13),
    SCORE_ACES_HIGH(14),
    SCORE_JOKER(20);

    private int value = 0;

    ScoresEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public boolean isPresent() {
        return this.value != 0;
    }

    public static List<ScoresEnum> getScores(String score) {
        return Arrays.stream(ScoresEnum.values())
                .filter(s -> s.getValue() == Integer.parseInt(score))
                .toList();
    }

    public static ScoresEnum getEnumByStringValue(String abbreviation) {
        return switch (abbreviation) {
            case "A" ->
                // default, logic elsewhere handles Aces High
                    ScoresEnum.SCORE_ACES_LOW;
            case "K" -> ScoresEnum.SCORE_KING;
            case "Q" -> ScoresEnum.SCORE_QUEEN;
            case "J" -> ScoresEnum.SCORE_JACK;
            default -> getScores(abbreviation).get(0);
        };
    }
}
