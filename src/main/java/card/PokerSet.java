package card;

import com.sun.deploy.util.StringUtils;

import java.util.*;

public class PokerSet implements Comparable {

    private Poker[] pokers;
    private HashMap<Integer, Integer> pairMap;

    public PokerSet(String cards) {
        pairMap = new HashMap<>();
        String[] cardStrs = cards.split(" ");
        pokers = new Poker[cardStrs.length];
        for (int i = 0; i < cardStrs.length; i++) {
            Poker poker = new Poker(cardStrs[i]);
            pokers[i] = poker;
        }
        sortPoker();
    }

    public void sortPoker() {
        Arrays.sort(pokers, new Comparator<Poker>() {
            @Override
            public int compare(Poker o1, Poker o2) {
                if (o1.getNum() != o2.getNum()) {
                    return o1.getNum() > o2.getNum() ? 1 : -1;
                } else {
                    return 0;
                }
            }
        });
    }

    public int getBiggest() {
        return pokers[pokers.length - 1].getNum();
    }

    public String poker2Strng() {
        List<String> pokerNums = new ArrayList<>();
        for (Poker poker : pokers) {
            pokerNums.add(poker.getPokerStr());
        }
        return StringUtils.join(pokerNums, " ");
    }

    private int pairNum() {
        for (int i = 0; i < pokers.length ; i++) {
            int pairNum = 1;
            pairNum = getPairNum(i, pairNum);
            if(pairNum > 1) pairMap.put(pokers[i].getNum(), pairNum);
        }
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
        int bigCard = 0;
        for(int value:pairMap.values()){
            if(value > bigCard) bigCard = value;
        }
        return bigCard;
    }

    @Override
    public int compareTo(Object o) {
        if(this.pairNum() == ((PokerSet) o).pairNum()) {
            if(this.getBigPairCard() == ((PokerSet) o).getBigPairCard()) return compareBySingle((PokerSet) o);
            return this.getBigPairCard() > ((PokerSet) o).getBigPairCard() ? 1 : -1;
        }
        return this.pairNum() > ((PokerSet) o).pairNum() ? 1 : -1;
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

    public Poker[] getPokers() {
        return pokers;
    }

    public HashMap<Integer, Integer> getPairMap() {
        return pairMap;
    }
}
