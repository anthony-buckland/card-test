package za.co.aboutblank.consts;

public class Errors {
    public static final String NO_SUIT = "You must enter a Suit, or Joker (J)";
    public static final String NO_SCORE_FOR_JOKER = "You cannot enter a score for a Joker (J)";
    public static final String SINGLE_CHAR_JOKER = "Please use an upper case J for Jokers. All other cards should have a value.";
    public static final String INVALID_CARD = "It appears you entered an invalid card. " +
            "Please use the path '/hand/help' to see the correct format";

    public static final String SCORE_OVER_LIMITS = "Please do not attempt to add a score over 10, J, Q, and K";
}
