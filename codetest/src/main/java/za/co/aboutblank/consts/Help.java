package za.co.aboutblank.consts;

public class Help {

    public static final String HELP_INSTRUCTIONS = String.join(
            System.getProperty("line.separator"),
            "Please enter a hand of 5 cards in the following format, suit followed by value and a comma. For example:",
            "Ace of Spaces -> SA",
            "10 of Clubs -> C10",
            "King of Diamonds -> DK",
            "Joker -> J (Note, jokers do not need a value)",
            "Queen of Hearts -> HQ",
            "And then makes the call to the path with the query '/hand?cards=SA,C10,DK,J,HQ'"
    );

}
