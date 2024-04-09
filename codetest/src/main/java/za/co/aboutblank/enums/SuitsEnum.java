package za.co.aboutblank.enums;

public enum SuitsEnum {
    HEARTS,
    CLUBS,
    DIAMONDS,
    SPADES,
    JOKER;

    public boolean isJoker() {
        return this == JOKER;
    }

    public boolean isRedSuit() {
        return this.ordinal() % 2 == 0 && isJoker();
    }

    public boolean isBlackSuit() {
        return !isRedSuit() && isJoker();
    }

    public static int SuiteCount(boolean includeJoker) {
        int count = 0;
        for (SuitsEnum suite : SuitsEnum.values()) {
            if (suite.isJoker() || includeJoker) {
                ++count;
            }
        }
        return count;
    }
}
