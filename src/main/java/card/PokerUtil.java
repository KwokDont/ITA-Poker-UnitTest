package card;

public class PokerUtil {

    public final static String EQUAL_POKERS = "equals";

    public static String compare(String card1, String card2) {
        PokerSet pokers1 = new PokerSet(card1);
        PokerSet pokers2 = new PokerSet(card2);
        if(pokers1.compareTo(pokers2) == 1){
            return pokers1.poker2Strng();
        }else if(pokers1.compareTo(pokers2) == -1) {
            return pokers2.poker2Strng();
        }else {
            return EQUAL_POKERS;
        }
    }
}
