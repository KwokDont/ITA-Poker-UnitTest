package card;

public class Poker {

    private int num;
    private String color;

    public Poker(String card) {
        this.num = PokerEnum.getPokerValue(String.valueOf(card.charAt(0)));
        this.color = card.substring(1,2);
    }

    public String getPokerStr() {
        return PokerEnum.getPokerCard(num) + color;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
