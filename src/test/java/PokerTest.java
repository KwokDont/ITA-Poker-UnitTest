import card.CardUtil;
import card.Poker;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PokerTest {

    @Test
     public void should_return_3C_when_given_3C_2S() {
        //Given
        String card1 = "3C";
        String card2 = "2S";
        //When
        String highCard = CardUtil.compare(card1, card2);
        //Then
        Assert.assertEquals(card1, highCard);
    }

}
