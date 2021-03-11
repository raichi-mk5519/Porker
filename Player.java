import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player extends Rule {
    final String name;
    int[] cards = new int[5];
    int score;

    Player(String name, int[] cards) {
        this.name = name;
        this.cards = cards;
    }

    public int[] trade(int[] cards, int[] buf) {
        for(int i = 0; i < buf.length;) {
            if(buf[i] == 0) {
                i++;
            } else {
                int r = new Random().nextInt(13);
                cards[i] = r + 1;
                i++;
            }
        }
        return cards;
    }

    public void printStatus() {
        System.out.println(name);
        for(int i = 0; i < CardsSIZE; i++){
            if(i == CardsSIZE - 1 ){
                System.out.println(cards[i]);
            }
            else {
                System.out.print(cards[i] + ",");
            }
        }
    }

}
