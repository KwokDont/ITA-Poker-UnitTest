package card;

public enum  PokerEnum {
    TWO("2", 2), THREE("3", 3), FOUR("4", 4), FIVE("5", 5),
    SIX("6", 6), SEVEN("7", 7), EIGHT("8", 8), NINE("9", 9), TEN("10", 10),
    JACK("J", 11), QUEEN("Q", 12), KING("K", 13), ACE("A", 14);

    private final String card;
    private final Integer value;

    public final static int ERROR_CARD = 0;

    PokerEnum(String card, Integer value) {
        this.card = card;
        this.value = value;
    }

    public static Integer getPokerValue(String card) {
        for (PokerEnum pokerEnum : PokerEnum.values()) {
            if (pokerEnum.getCard().equals(card)) {
                return pokerEnum.getValue();
            }
        }
        return ERROR_CARD;
    }

    public String getCard() {
        return card;
    }

    public Integer getValue() {
        return value;
    }
}
