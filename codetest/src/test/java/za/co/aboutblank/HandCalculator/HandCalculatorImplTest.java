package za.co.aboutblank.HandCalculator;

import org.junit.jupiter.api.Test;
import za.co.aboutblank.enums.ScoresEnum;
import za.co.aboutblank.enums.SuitsEnum;
import za.co.aboutblank.exceptions.InvalidCardException;
import za.co.aboutblank.models.Card;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HandCalculatorImplTest {

    @Test
    public void isStraightFlushTestTest() throws InvalidCardException {
        List<Card> cards = Arrays.asList(
              new Card(SuitsEnum.CLUBS, ScoresEnum.SCORE_2)
        );


    }

    @Test
    public void isFourOfAKindTest() {

        
    }

    @Test
    public void isFullHouseTest() {

        
    }

    @Test
    public void isFlushTest() {

        
    }

    @Test
    public void isStraightTest() {

        
    }

    @Test
    public void isThreeOfAKindTest() {

        
    }


    @Test
    public void isTwoPairTest() {

        
    }

    @Test
    public void isOnePairTest() {

        
    }

    @Test
    public void isHighCardTest()
    {

        
    }
}
