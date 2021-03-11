public class Rule {
    static int CardsSIZE = 5;
    /*static enum type {
        noPair(0), onePair(100), twoPair(1000), threeCard(10000), hullHouse(50000), fourCard(100000);
    }*/
    
    static int setPoint(int[] cards) {
        int matchCount = 0;
        int onePair = 0;
        boolean pair = false;
        int point = 0;
        int priority = 0;
        for(int i = 0; i < CardsSIZE; i++) {
            //priority = 0;
            matchCount = 0;

            if(i < 4) {
                for(int j = i + 1; j < CardsSIZE;){
                    if(cards[j - 1] == cards[j]){
                        matchCount += 1;
                    } else {
                        break;
                    }
                    j++;
                }
            }

            switch (matchCount){
                case 1:
                if(priority == 1 && pair == true) {
                    point += 100 + cards[i] - onePair;
                } else if (priority > 1 && i < 3){
                    break;
                } else if (priority <= 1) {
                    point = 100 + cards[i];
                } else if (priority > 1 && i >= 3 && point < 5000 && cards[0] == cards[1]) {
                    point = 4000 + point;
                    break;
                }
                priority = 1;
                pair = true;
                onePair = cards[i];
                break;

                case 2:
                if(priority == 1 && pair == true){
                    point = 5000 + cards[i];
                } else if (priority <= 2) {
                    point = 1000 + cards[i];
                } else {
                    break;
                }
                priority = 2;
                break;

                case 3:
                point = 10000 + cards[i];
                priority = 3;
                break;

                case 4:
                point = 100000 + cards[i];
                priority = 4;
                break;

                default:
                if(priority == 0 && point < 14){
                    point = cards[i];
                }
                else{
                    break;
                }
                break;
            }

            /*if (priority == 2 || priority == 3){
                break;
            }*/

            if (priority == 3){
                break;
            }

            if (i == CardsSIZE - 1) {
                if (point == 0) {
                    return cards[i];
                }
                break;
            }
        }
        return point;
    }

    public static void Winner(String player1Name, int player1Score, String player2Name, int player2Score) {
        /*System.out.println(player1Name + ":" + player1Score);
        System.out.println(player2Name + ":" + player2Score);
        System.out.println("");*/

        if(player1Score < player2Score) {
            System.out.println("winner: " + player2Name);
        } else if(player2Score < player1Score) {
            System.out.println("winner: " + player1Name);
        } else {
            System.out.println("drow");
        }
    }
}
