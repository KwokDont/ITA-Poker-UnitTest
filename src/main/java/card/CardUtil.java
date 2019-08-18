package card;

public class CardUtil {

    public static Poker compare(String card1, String card2) {

        return Integer.parseInt(card1.substring(0, 1)) > Integer.parseInt(card2.substring(0, 1)) ? new Poker(card1) : new Poker(card2);
    }
}
