package za.co.aboutblank.mappers;

import org.junit.jupiter.api.Test;
import za.co.aboutblank.enums.ScoresEnum;
import za.co.aboutblank.enums.SuitsEnum;
import za.co.aboutblank.exceptions.InvalidCardException;
import za.co.aboutblank.models.Card;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MapInputToCardTest {

    MapInputToCard sut = new MapInputToCard();

    @Test
    void abbreviationToCardTestJokerOnly() throws InvalidCardException {
        var input = List.of("j"); // NOTE: Lower case by intention
        ArrayList<Card> output = sut.abbreviationToCard(input);
        assertAll("Test if the abbreviated Joker value has been converted to Enum",
                () -> assertEquals(SuitsEnum.valueOf("JOKER"), output.get(0).getSuit(),
                        "Suit should be JOKER"),
                () -> assertEquals(ScoresEnum.valueOf("SCORE_JOKER"),
                        output.get(0).getScore(), "Score should be SCORE_JOKER"));
    }

    @Test
    void abbreviationToCardTestDoubleCharValues() throws InvalidCardException {
        var input = List.of("CA", "C2", "S3", "S4", "HK");
        ArrayList<Card> output = sut.abbreviationToCard(input);

        assertAll("Test if all the abbreviated values have been converted to Enums (non ordered)",
                () -> assertEquals(SuitsEnum.valueOf("CLUBS"),
                        output.get(0).getSuit(), "Suit should be CLUBS"),
                () -> assertEquals(ScoresEnum.valueOf("SCORE_ACES_LOW"),
                        output.get(0).getScore(), "Score should be SCORE_ACES_LOW"),
                () -> assertEquals(SuitsEnum.valueOf("CLUBS"),
                        output.get(1).getSuit(), "Suit should be CLUBS"),
                () -> assertEquals(ScoresEnum.valueOf("SCORE_2"),
                        output.get(1).getScore(), "Score should be SCORE_2"),
                () -> assertEquals(SuitsEnum.valueOf("SPADES"),
                        output.get(2).getSuit(), "Suit should be SPADES"),
                () -> assertEquals(ScoresEnum.valueOf("SCORE_3"),
                        output.get(2).getScore(), "Score should be SCORE_3"),
                () -> assertEquals(SuitsEnum.valueOf("SPADES"),
                        output.get(3).getSuit(), "Suit should be SPADES"),
                () -> assertEquals(ScoresEnum.valueOf("SCORE_4"),
                        output.get(3).getScore(), "Score should be SCORE_4"),
                () -> assertEquals(SuitsEnum.valueOf("HEARTS"),
                        output.get(4).getSuit(), "Suit should be HEARTS"),
                () -> assertEquals(ScoresEnum.valueOf("SCORE_KING"),
                        output.get(4).getScore(), "Score should be SCORE_KING"));

    }

    @Test
    void abbreviationToCardThreeCharTestValues() throws InvalidCardException {
        var input = List.of("C10");
        ArrayList<Card> output = sut.abbreviationToCard(input);

        assertAll("Test if the abbreviated 3 char values have been converted to Enums", () -> assertEquals(SuitsEnum.valueOf("CLUBS"), output.get(0).getSuit(), "Suit should be CLUBS"), () -> assertEquals(ScoresEnum.valueOf("SCORE_10"), output.get(0).getScore(), "Score should be SCORE_10"));
    }

    @Test
    void abbreviationToCardFourCharTestValues() {
        var input = List.of("C100");
        assertThrows(InvalidCardException.class, () -> {
            ArrayList<Card> output = sut.abbreviationToCard(input);
        });
    }

}
