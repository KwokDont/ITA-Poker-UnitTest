package card;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PokerSet implements Comparable {

    private Poker[] pokers;
    public int weight;

    public PokerSet(String cards) {
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

    @Override
    public int compareTo(Object o) {
        if (this.getBiggest() != ((PokerSet) o).getBiggest()) {
            if (this.getBiggest() > ((PokerSet) o).getBiggest())
                return 1;
            else
                return -1;
        } else
            return 0;
    }

    public Poker[] getPokers() {
        return pokers;
    }

    public int getWeight() {
        return weight;
    }
}
