package za.co.aboutblank.enums;

public enum ScoresEnum {
    SCORE_ACES_LOW (1),
    SCORE_2 (2),
    SCORE_3 (3),
    SCORE_4 (4),
    SCORE_5 (5),
    SCORE_6 (6),
    SCORE_7(7),
    SCORE_8 (8),
    SCORE_9 (9),
    SCORE_10 (10),
    SCORE_JACK (11),
    SCORE_QUEEN (12),
    SCORE_KING (13),
    SCORE_ACES_HIGH(14),
    SCORE_JOKER(20);

    private int value = 0;
    ScoresEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    } 
}
