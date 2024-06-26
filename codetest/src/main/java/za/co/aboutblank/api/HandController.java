package za.co.aboutblank.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import za.co.aboutblank.HandCalculator.HandType;
import za.co.aboutblank.exceptions.InvalidCardException;
import za.co.aboutblank.mappers.MapInputToCard;

import java.util.List;

import static za.co.aboutblank.consts.Errors.NOT_ENOUGH_CARDS;
import static za.co.aboutblank.consts.Help.HELP_INSTRUCTIONS;

@Controller
public class HandController {
    @RequestMapping(value = "/hand", method = RequestMethod.GET)
    public @ResponseBody String handleHandRequest(@RequestParam(name = "cards") String hand) {
        var mapper = new MapInputToCard();
        // simple validation
        var cardsAsList = List.of(hand.split(","));
        if (cardsAsList.size() != 5) {
            return NOT_ENOUGH_CARDS;
        }
        try {
            return HandType.describe(
                    mapper.abbreviationToCard(
                            cardsAsList
                    )
            );
        } catch (InvalidCardException ex) {
            return ex.getMessage();
        }
    }

    @RequestMapping(value = "/hand/help", method = RequestMethod.GET)
    public @ResponseBody String handleHelpRequest() {
        return HELP_INSTRUCTIONS;
    }
}
