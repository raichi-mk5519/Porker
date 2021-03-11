import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class Porker extends Rule {
    private static int[] buf = new int[CardsSIZE];

    public static void countPoint(int point) {
        if(point < 100) {
            System.out.println("NoPair");
        } else if(point < 200) {
            System.out.println("OnePair");
        } else if(point >200 && point < 1000) {
            System.out.println("TwoPair");
        } else if(point >1000 && point < 5000) {
            System.out.println("ThreeCard");
        } else if(point > 5000 && point < 10000) {
            System.out.println("FullHouse");
        } else {
            System.out.println("FourCard");
        }
        System.out.println("");
        System.out.println(point);
        System.out.println("");
    }

    public static int[] makeBuffer(int[] buf) {
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < CardsSIZE; i++) {
            buf[i] = scan.nextInt();
        }
        return buf;
    }

    public static void playPorker(Player player) {
        player.printStatus();
        System.out.println("");
        buf = makeBuffer(buf);
        player.cards = player.trade(player.cards, buf);
        Arrays.sort(player.cards);
        System.out.println("");
    }

    public static int[] test(int[] cards) {
        cards[0] = 4;
        cards[1] = 4;
        cards[2] = 6;
        cards[3] = 6;
        cards[4] = 6;
        return cards;
    }

    public static void main(String[] args) {
        //int CardsSIZE = 5;
        int point1 = 0;
        int point2 = 0;
        int[] cards1 = new int[CardsSIZE];
        int[] cards2 = new int[CardsSIZE];

        for(int i = 0; i < CardsSIZE; i++) {
            int r = new Random().nextInt(13);
            int l = new Random().nextInt(13);
            cards1[i] = r + 1;
            cards2[i] = l + 1;
        }

        //test(cards1);

        Player player1 = new Player(args[0], cards1);
        Player player2 = new Player(args[1], cards2);

        Arrays.sort(player1.cards);
        Arrays.sort(player2.cards);
        
        playPorker(player1);
        playPorker(player2);

        point1 = Rule.setPoint(player1.cards);
        point2 = Rule.setPoint(player2.cards);

        player1.printStatus();
        countPoint(point1);
        player2.printStatus();
        countPoint(point2);

        Winner(player1.name, point1, player2.name, point2);
    }

}
