import card.PokerUtil;
import card.Poker;
import org.junit.Assert;
import org.junit.Test;

public class PokerTest {

    @Test
     public void should_return_3C_when_given_3C_2S() {
        String card1 = "3C";
        String card2 = "2S";

        String highCard = PokerUtil.compare(card1, card2);

        Assert.assertEquals(card1, highCard);
    }

    @Test
    public void should_return_KC_when_given_KC_2S() {
        String card1 = "KC";
        String card2 = "2S";

        String highCard = PokerUtil.compare(card1, card2);

        Assert.assertEquals(card1, highCard);
    }

    @Test
    public void should_return_card1_when_compare_bigger_card1_and_card2() {
        String cards1 = "2C 3S 5D 6D 8S";
        String cards2 = "2C 3S 5D 6D 9S";

        String highCard = PokerUtil.compare(cards1, cards2);

        Assert.assertEquals(cards2, highCard);
    }

    @Test
    public void should_return_card2_when_compare_bigger_card2_and_card1() {
        String cards1 = "2D 4C 5C 6C 9D";
        String cards2 = "2C 3S 5D 6D 9S";

        String highCard = PokerUtil.compare(cards1, cards2);

        Assert.assertEquals(cards1, highCard);
    }

    @Test
    public void should_return_equal_when_card1_and_card2_has_same_num() {
        String cards1 = "2D 3C 5C 6C 9D";
        String cards2 = "2C 3S 5D 6D 9S";

        String highCard = PokerUtil.compare(cards1, cards2);

        Assert.assertEquals(PokerUtil.EQUAL_POKERS, highCard);
    }

    @Test
    public void should_return_card1_when_card1_has_pair() {
        String cards1 = "2D 2C 5C 6C 9D";
        String cards2 = "2C 3S 5D 6D 9S";

        String highCard = PokerUtil.compare(cards1, cards2);

        Assert.assertEquals(cards1, highCard);
    }
    @Test
    public void should_return_card1_when_has_same_pair() {
        String cards1 = "2D 2S 5C 6C TD";
        String cards2 = "2C 2H 5D 6D 9S";

        String highCard = PokerUtil.compare(cards1, cards2);

        Assert.assertEquals(cards1, highCard);
    }

    @Test
    public void should_return_card1_when_card1_has_bigger_pair() {
        String cards1 = "3D 3S 5C 6C 9D";
        String cards2 = "2C 2H 5D 6D 9S";

        String highCard = PokerUtil.compare(cards1, cards2);

        Assert.assertEquals(cards1, highCard);
    }

    @Test
    public void should_return_card1_when_card1_has_two_pair() {
        String cards1 = "3D 3S 4C 4C 9D";
        String cards2 = "2C 3H 5D 5D 9S";

        String highCard = PokerUtil.compare(cards1, cards2);

        Assert.assertEquals(cards1, highCard);
    }

    @Test
    public void should_return_card1_when_card1_second_pair_bigger() {
        String cards1 = "3D 3S 5C 5S 9D";
        String cards2 = "2C 2H 5H 5D 9S";

        String highCard = PokerUtil.compare(cards1, cards2);

        Assert.assertEquals(cards1, highCard);
    }
    @Test
    public void should_return_card1_when_card1_has_bigger_single_poker() {
        String cards1 = "2D 2S 5C 5S KD";
        String cards2 = "2C 2H 5H 5D 9S";

        String highCard = PokerUtil.compare(cards1, cards2);

        Assert.assertEquals(cards1, highCard);
    }

    @Test
    public void should_return_equals_when_card1_has_bigger_single_poker() {
        String cards1 = "2D 2S 5C 5S KD";
        String cards2 = "2C 2H 5H 5D KS";

        String highCard = PokerUtil.compare(cards1, cards2);

        Assert.assertEquals(PokerUtil.EQUAL_POKERS, highCard);
    }

    @Test
    public void should_return_card1_when_card1_has_three_same_poker() {
        String cards1 = "2D 2S 2C 5S KD";
        String cards2 = "2C 2H 5H 5D KS";

        String highCard = PokerUtil.compare(cards1, cards2);

        Assert.assertEquals(cards1, highCard);
    }

    @Test
    public void should_return_card1_when_card1_has_bigger_three_same_poker_than_card2() {
        String cards1 = "3D 3S 3C 5S TD";
        String cards2 = "2C 2H 2H 5D KS";

        String highCard = PokerUtil.compare(cards1, cards2);

        Assert.assertEquals(cards1, highCard);
    }

    @Test
    public void should_return_card1_when_card1_straight_and_card_is_three() {
        String cards1 = "3D 3S 3C 5S TD";
        String cards2 = "2C 3H 4H 5D 6S";

        String highCard = PokerUtil.compare(cards1, cards2);

        Assert.assertEquals(cards2, highCard);
    }

    @Test
    public void should_return_equals_when_card1_card2_straight_and_the_same() {
        String cards1 = "2D 3S 4C 5S 6D";
        String cards2 = "2C 3H 4H 5D 6S";

        String highCard = PokerUtil.compare(cards1, cards2);

        Assert.assertEquals(PokerUtil.EQUAL_POKERS, highCard);
    }

    @Test
    public void should_return_card1_when_card1_card2_straight_and_card1_bigger() {
        String cards1 = "3D 4S 5C 6S 7D";
        String cards2 = "2C 3H 4H 5D 6S";

        String highCard = PokerUtil.compare(cards1, cards2);

        Assert.assertEquals(cards1, highCard);
    }
}
