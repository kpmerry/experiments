import java.util.HashMap;
import java.util.Scanner;

class BlackJackGame extends CardGame {
    private Deck d;
    private Hand compHand;
    private Hand playHand;
    private HashMap<String, Integer> rankVals;
    private Scanner in;
    private long speed;

    public BlackJackGame() {
        super("Black Jack");
        compHand = new Hand();
        playHand = new Hand();
        d = new Deck();
        d.shuffleCards();
        playHand.drawCardFrom(d, 2);
        compHand.drawCardFrom(d, 2);
        compHand.hideCards();
        rankVals = new HashMap<String, Integer>();
        initRankvals();
        in = new Scanner(System.in);
        speed = 500;
    }

    private void initRankvals() {
        String[] RANKS = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
        int[] VALS = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };
        for (int i = 0; i < 13; i++) {
            rankVals.put(RANKS[i], VALS[i]);
        }
    }

    public Hand getPlayHand() {
        return playHand;
    }

    public Hand getCompHand() {
        return compHand;
    }

    public void gamePlay() {
        // Show one card of dealer's hand.
        compHand.unhideCard(0);
        // Player has their turn.
        while (getHandValue(playHand) <= 21) {
            showTable();
            if (drawAnother()) {
                playHand.drawCardFrom(d);
            } else {
                break;
            }
        }
        pause(1000);
        if (getHandValue(playHand) <= 21) {
            // Dealer has their turn.
            dealersTurn(compHand);
        }
        compHand.unhideCards();
        compHand.fancyPrint();
        playHand.fancyPrint();

        typingEffect(" ---- RESULTS ---- ");
        System.out.printf("Player : %s\nComputer : %s", getHandValue(playHand),
                getHandValue(compHand));
        if ((getHandValue(compHand) <= 21)
                && ((getHandValue(playHand) > 21)
                        || (getHandValue(compHand) > getHandValue(playHand)))) {
            loseGame();
        } else if ((getHandValue(playHand) <= 21)
                && ((getHandValue(playHand) > getHandValue(compHand))
                        || (getHandValue(compHand) > 21))) {
            winGame();
        } else if (getHandValue(compHand) == getHandValue(playHand)) {
            drawGame();
        }
    }

    private void showTable() {
        pause(speed);
        System.out.print("Computer :\n");
        compHand.fancyPrint();
        pause(speed);
        System.out.print("Player :\n");
        playHand.fancyPrint();
        pause(speed);
        System.out.println("Your hand's value : " + getHandValue(playHand));

    }

    private boolean drawAnother() {
        String question = "\nYour current score is %s.\nDraw another card?(Y/N) : ";
        System.out.printf(question, getHandValue(playHand));
        String ans = in.nextLine().strip().toLowerCase();
        if (ans.equalsIgnoreCase("y")) {
            return true;
        } else if (ans.equalsIgnoreCase("n")) {
            return false;
        }
        return drawAnother();
    }

    private int getHandValue(Hand h) {
        int count = 0;
        for (Card c : h.cards) {
            count += rankVals.get(c.getRank());
        }
        return count;
    }

    private void dealersTurn(Hand h) {
        while (getHandValue(h) < 17) {
            d.dealCardTo(h);
        }
    }
}
