import card.CardUtil;
import card.Poker;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PokerTest {

    @Test
     public void should_return_3C_when_given_3C_2S() {
        String card1 = "3C";
        String card2 = "2S";

        Poker highCard = CardUtil.compare(card1, card2);

        Assert.assertEquals(new Poker(card1).getNum(), highCard.getNum());
        Assert.assertEquals(new Poker(card1).getColor(), highCard.getColor());
    }

}
