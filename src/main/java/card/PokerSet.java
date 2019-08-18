package card;

import com.sun.deploy.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class PokerSet implements Comparable {

    private Poker[] pokers;
    private HashMap<Integer, Integer> pairMap;

    private final static int IS_STRAIGHT = 1;
    private final static int NOT_STRAIGHT = 0;

    public PokerSet(String cards) {
        pairMap = new HashMap<>();
        generatePokerArray(cards);
        sortPoker();
        generatePairMap();
    }

    private void generatePokerArray(String cards) {
        String[] cardStrs = cards.split(" ");
        pokers = new Poker[cardStrs.length];
        for (int i = 0; i < cardStrs.length; i++) {
            Poker poker = new Poker(cardStrs[i]);
            pokers[i] = poker;
        }
    }

    public void sortPoker() {
        Arrays.sort(pokers, new Comparator<Poker>() {
            @Override
            public int compare(Poker o1, Poker o2) {
                return o1.getNum() != o2.getNum() ? o1.getNum() > o2.getNum() ? 1 : -1 : 0;
            }
        });
    }

    private void generatePairMap() {
        for (int i = 0; i < pokers.length ; i++) {
            if(pairMap.keySet().contains(pokers[i].getNum())) continue;
            int pairNum = 1;
            pairNum = getPairNum(i, pairNum);
            if(pairNum > 1) pairMap.put(pokers[i].getNum(), pairNum);
        }
    }

    public int getBiggest() {
        return pokers[pokers.length - 1].getNum();
    }

    public String poker2Strng() {
        List<String> pokerNums = Arrays.stream(pokers).map(Poker::getPokerStr).collect(Collectors.toList());
        return StringUtils.join(pokerNums, " ");
    }

    private int pairNum() {
        return pairMap.keySet().size();
    }

    private int getPairNum(int i, int pairNum) {
        for (int j = i + 1; j < pokers.length; j++) {
            if (pokers[i].getNum() == pokers[j].getNum()) {
                pairNum++;
            }
        }
        return pairNum;
    }

    private int getBigPairCard() {
        int bigCard = pairMap.keySet().stream().mapToInt(value -> value).filter(value -> value >= 0).max().orElse(0);
        return bigCard;
    }

    private int getSecondPairCard() {
        int secondCard = pairMap.keySet().stream().mapToInt(value -> value).filter(value -> value >= 0).min().orElse(0);
        return secondCard;
    }

    private int getMaxSameCardNum() {
        int sameCardNum = pairMap.values().stream().mapToInt(num -> num).filter(num -> num >= 0).max().orElse(0);
        return sameCardNum;
    }

    @Override
    public int compareTo(Object o) {
        if(this.isStraight() == IS_STRAIGHT && ((PokerSet) o).isStraight() == IS_STRAIGHT) {
            if(this.getBiggest() == ((PokerSet) o).getBiggest()) return 0;
            return this.getBiggest() > ((PokerSet) o).getBiggest() ? 1 : -1;
        }else if(this.isStraight() == NOT_STRAIGHT && ((PokerSet) o).isStraight() == NOT_STRAIGHT) {
            return compareWithThree((PokerSet) o);
        }
        return this.isStraight() > ((PokerSet) o).isStraight() ? 1 : -1;
    }

    private int compareWithThree(PokerSet o) {
        if(this.getMaxSameCardNum() == o.getMaxSameCardNum()) {
            if(this.pairNum() == o.pairNum()) return compareWithPair(o);
            return this.pairNum() > o.pairNum() ? 1 : -1;
        }
        return this.getMaxSameCardNum() > o.getMaxSameCardNum() ? 1 : -1;
    }

    private int compareWithPair(PokerSet o) {
        if(this.getBigPairCard() == o.getBigPairCard()) {
            if(this.getSecondPairCard() == o.getSecondPairCard()) return compareBySingle(o);
            return this.getSecondPairCard() > o.getSecondPairCard() ? 1 : -1;
        }
        return this.getBigPairCard() > o.getBigPairCard() ? 1 : -1;
    }

    private int compareBySingle(PokerSet o) {
        for(int i = pokers.length - 1 ; i >= 0 ; i--) {
            if(pokers[i].getNum() > o.getPokers()[i].getNum()) {
                return 1;
            }else if (pokers[i].getNum() < o.getPokers()[i].getNum()){
                return -1;
            }
        }
        return 0;
    }

    private int isStraight() {
        if (pokers.length == 1) return IS_STRAIGHT;
        for(int i = pokers.length - 1 ; i > 0 ; i--) {
            if(pokers[i].getNum() - pokers[i-1].getNum() != 1) {
                return NOT_STRAIGHT;
            }
        }
        return IS_STRAIGHT;
    }

    public Poker[] getPokers() {
        return pokers;
    }

    public HashMap<Integer, Integer> getPairMap() {
        return pairMap;
    }
}
