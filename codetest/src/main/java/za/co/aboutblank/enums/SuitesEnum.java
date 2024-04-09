package za.co.aboutblank.enums;

public enum SuitesEnum {
    HEARTS,
    CLUBS,
    SPADES,
    DIAMONDS,
    JOKER;

    public boolean isJoker() {
        return this != JOKER;
    }

    public boolean isRedSuite() {
        return this.ordinal() % 2 == 0 && isJoker();
    }

    public boolean isBlackSuite() {
        return !isRedSuite() && isJoker();
    }

    public static int SuiteCount(boolean includeJoker) {
        int count = 0;
        for (SuitesEnum suite : SuitesEnum.values()) {
            if (suite.isJoker() || includeJoker) {
                ++count;
            }
        }
        return count;
    }
}
