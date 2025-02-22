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
        // Initialise class attributes.
        rankVals = new HashMap<String, Integer>();
        compHand = new Hand("Computer");
        playHand = new Hand("Player");
        in = new Scanner(System.in);
        d = new Deck();
        // Prepare deck and players' hands.
        d.shuffleCards();
        playHand.drawCardFrom(d, 2);
        compHand.drawCardFrom(d, 2);
        compHand.hideCards();
        // Add values to the hashmap.
        initRankvals();
        speed = 500;
    }

    private void initRankvals() {
        final String[] RANKS = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
        final int[] VALS = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };
        // Add ranks and vals to the hashmap.
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

        // Reveal final hand values.
        typingEffect(" ---- RESULTS ---- ");
        int playScore = getHandValue(playHand);
        int compScore = getHandValue(compHand);
        System.out.printf("Player: %s\nComputer: %s\n", playScore, compScore);
        pause(speed);

        // Determine win, loss, or draw for the player.
        if (compScore <= 21 && ((playScore > 21) || (compScore > playScore))) {
            loseGame();
        } else if (playScore <= 21 && (playScore > compScore) || compScore > 21) {
            winGame();
        } else if (compScore == playScore) {
            drawGame();
        }

        pause(1000);
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
        String question2 = "Draw another card?(Y/N) : ";
        typingEffect(question2);

        // Check player's answer.
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
        // Sum cards' rank values.
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
