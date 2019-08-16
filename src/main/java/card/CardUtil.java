package card;

public class CardUtil {

    public static String compare(String card1, String card2) {

        return Integer.parseInt(card1.substring(0, 1)) > Integer.parseInt(card2.substring(0, 1)) ? card1 : card2;
    }
}
