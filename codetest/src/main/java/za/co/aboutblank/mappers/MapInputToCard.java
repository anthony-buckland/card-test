package za.co.aboutblank.mappers;

import za.co.aboutblank.enums.ScoresEnum;
import za.co.aboutblank.enums.SuitsEnum;
import za.co.aboutblank.exceptions.InvalidCardException;
import za.co.aboutblank.models.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static za.co.aboutblank.consts.Errors.*;

public class MapInputToCard {

    public ArrayList<Card> abbreviationToCard(List<String> input) throws InvalidCardException {
        var output = new ArrayList<Card>(List.of());
        for (String item : input) {
            switch (item.trim().length()) {
                // We do need to convert the higher values (and Ace) to an integer value before
                // we look it up, as they are currently Strings. Default to 'Aces Low', we test elsewhere
                case 1 -> {
                    // This should only be a joker. No card value or suit needs to be handled.
                    if (!item.trim().equalsIgnoreCase("J")) {
                        throw new InvalidCardException(SINGLE_CHAR_JOKER);
                    } else {
                        output.add(new Card(SuitsEnum.JOKER, ScoresEnum.SCORE_JOKER));
                    }
                }
                case 2 -> {
                    // Convert to the enum, upper case (not needed for integer values but does no harm
                    var suit = SuitsEnum.get(item.trim()
                            .substring(0, 1)
                            .toUpperCase()
                    );
                    var score = ScoresEnum.getEnumByStringOrValue(item.trim()
                            .substring(1, 2)
                            .toUpperCase()
                    );

                    if (suit.isPresent() && score.isPresent()) {
                        output.add(new Card(suit.get(), score));
                    } else {
                        throw new InvalidCardException(INVALID_CARD);
                    }
                }
                case 3 -> {
                    // example: H10
                    var trimmed = item.trim()
                            .substring(0, 1)
                            .toUpperCase();
                    Optional<SuitsEnum> suit;
                    ScoresEnum score;
                    try {
                        suit = SuitsEnum.get(trimmed);
                        score = ScoresEnum.getEnumByStringOrValue(item.trim()
                                .substring(1, 3)
                                .toUpperCase());
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        // this when someone enters an invalid score
                        throw new InvalidCardException(SCORE_OVER_LIMITS);
                    }

                    if (suit.isPresent() && score.isPresent()) {
                        output.add(new Card(suit.get(), score));
                    } else {
                        throw new InvalidCardException(INVALID_CARD);
                    }
                }
                default -> {
                    throw new InvalidCardException(INVALID_CARD);
                }
            }


        }
        return output;
    }
}
