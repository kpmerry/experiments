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
        super("Black Jack!");
        compHand = new Hand("Computer");
        playHand = new Hand("Player");
        d = new Deck();
        d.shuffleCards();
        playHand.drawCardFrom(d, 2);
        compHand.drawCardFrom(d, 2);
        compHand.hideCards();
        rankVals = new HashMap<String, Integer>();
        // Add values to the hashmap.
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
            pause(speed * 2);
            // Player chooses when hand is complete.
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
        // Display cards.
        compHand.unhideCards();
        showTable();

        typingEffect(" ---- RESULTS ---- ");
        int playerScore = getHandValue(playHand);
        int dealerScore = getHandValue(compHand);
        System.out.printf("%s\n%s", playerScore, dealerScore);

        // Determine win, loss, or draw for the player.
        if ((getHandValue(compHand) <= 21) && ((getHandValue(playHand) > 21)
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
        compHand.fancyPrint();
        pause(speed);
        playHand.fancyPrint();
        pause(speed);
        System.out.println("Your hand's value : " + getHandValue(playHand) + "\n");

    }

    private boolean drawAnother() {
        String question1 = "\nYour current score is %s.";
        String question2 = "\nDraw another card?(Y/N) : ";
        System.out.printf(question1, getHandValue(playHand));
        pause(speed);
        typingEffect(question2);
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
