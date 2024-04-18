package za.co.aboutblank;

import za.co.aboutblank.exceptions.InvalidCardException;
import za.co.aboutblank.exceptions.InvalidHandException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        var console = System.console();

        while (true) {
            List<String> input = Arrays.asList(console.readLine().split("\\s+"));
            //try {

                if (Objects.equals(input.get(0), "-help")) {
                    System.out.println("Please enter a hand of 5 cards in the following format, for example:");
                    System.out.println("Ace of Spaces -> AS");
                    System.out.println("10 of Clubs -> 10C");
                    System.out.println("King of Diamonds -> KD");
                    System.out.println("Joker -> J");
                }
                if (input.size() == 5) {
                    System.out.println("You have a " + Arrays.toString(input.toArray()));
                } else {
                    System.out.println("Please enter a hand of 5 cards. To review the instructions, enter '-help'");
                }
            //} catch (InvalidCardException | InvalidHandException ex) {
            //    System.out.println(ex.getMessage());
            //}
        }
    }
}
