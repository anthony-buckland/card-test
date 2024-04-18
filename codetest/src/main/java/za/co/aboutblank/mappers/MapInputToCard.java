package za.co.aboutblank.mappers;

import za.co.aboutblank.enums.ScoresEnum;
import za.co.aboutblank.enums.SuitsEnum;
import za.co.aboutblank.exceptions.InvalidCardException;
import za.co.aboutblank.models.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MapInputToCard {

    public ArrayList<Card> abbreviationToCard(List<String> input) throws InvalidCardException {
        var output = new ArrayList<Card>(List.of());
        for (String item : input) {
            switch (item.length()) {
                // We do need to convert the higher values (and Ace) to an integer value before
                // we look it up, as they are currently Strings. Default to Aces Low, we test elsewhere

                case 1 -> {
                    // This should only be a joker. No card value or suit needs to be handled.
                    if (!item.equalsIgnoreCase("J")) {
                        throw new InvalidCardException("Please use an upper case J for Jokers");
                    } else {
                        output.add(new Card(SuitsEnum.JOKER, ScoresEnum.SCORE_JOKER));
                    }
                }
                case 2 -> {
                    // Convert to the enum, upper case (not needed for integer values)
                    var suit = SuitsEnum.get(item.substring(0, 1).toUpperCase());
                    var score = ScoresEnum.getEnumByStringValue(item.substring(1, 2).toUpperCase());
                    if (suit.isPresent() && score.isPresent()) {
                        output.add(new Card(suit.get(), score));
                    } else {
                        throw new InvalidCardException("It appears you entered an invalid card. " +
                                "Please use the command '-help' to see the correct format");
                    }
                }
                case 3 -> {
                    var suit = SuitsEnum.get(item.substring(0, 1).toUpperCase());
                    var score = ScoresEnum.getEnumByStringValue(item.substring(1, 3).toUpperCase());
                    if (suit.isPresent() && score.isPresent()) {
                        output.add(new Card(suit.get(), score));
                    } else {
                        throw new InvalidCardException("It appears you entered an invalid card. " +
                                "Please use the command '-help' to see the correct format");
                    }
                }
                default -> {
                    throw new InvalidCardException("It appears you entered an invalid card. " +
                            "Please use the command '-help' to see the correct format");
                }
            }


        }
        return output;
    }

    private Optional<ScoresEnum> convertScoreToInt(String score) {
        return Optional.ofNullable(ScoresEnum.getEnumByStringValue(score));
    }
}
