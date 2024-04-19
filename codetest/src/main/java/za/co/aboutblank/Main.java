package za.co.aboutblank;

import za.co.aboutblank.HandCalculator.HandType;
import za.co.aboutblank.exceptions.InvalidCardException;
import za.co.aboutblank.exceptions.InvalidHandException;
import za.co.aboutblank.mappers.MapInputToCard;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        var console = System.console();

        do {
            List<String> input = Arrays.asList(console.readLine().split("\\s+"));
            try {

                if (Objects.equals(input.get(0), "-help")) {
                    System.out.println("Please enter a hand of 5 cards in the following format, suit followed by value. For example:");
                    System.out.println("Ace of Spaces -> SA");
                    System.out.println("10 of Clubs -> C10");
                    System.out.println("King of Diamonds -> DK");
                    System.out.println("Joker -> J");
                }
                if (input.size() == 5) {
                    System.out.println("You have entered " + Arrays.toString(input.toArray()));
                    var mapper = new MapInputToCard();
                    var hand = mapper.abbreviationToCard(input);
                    var text = HandType.describe(hand);
                    System.out.println(text);
                } else {
                    System.out.println("Please enter a hand of 5 cards. To review the instructions, enter '-help'");
                }
            } catch (Exception ex) {

                System.out.println(ex.getMessage());
            }
        } while (true);
    }
}
