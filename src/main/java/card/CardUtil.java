package card;

public class CardUtil {

    public static Poker compare(String card1, String card2) {
        Poker poker1 = new Poker(card1);
        Poker poker2 = new Poker(card2);
        return poker1.getNum() > poker2.getNum() ? poker1 : poker2;
    }
}
