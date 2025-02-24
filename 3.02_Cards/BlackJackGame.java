import java.util.HashMap;
import java.util.Scanner;

class BlackJackGame extends CardGame implements StandardDeck {
    private Deck d;
    private Hand compHand;
    private Hand playHand;
    private HashMap<String, Integer> rankVals;
    private Scanner in;
    private long speed;

    public BlackJackGame() {
        super("Black Jack");
        // Initialise class attributes.
        rankVals = new HashMap<String, Integer>();
        compHand = new Hand("Computer");
        playHand = new Hand("Player");
        in = new Scanner(System.in);
        d = new Deck();
        speed = 500;
        // Prepare deck and players' hands.
        dealHands();
        // Add initialise hashmap.
        initRankvals();
    }

    private void initRankvals() {
        final int[] VALS = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };
        // Add ranks and vals to the hashmap.
        for (int i = 0; i < 13; i++) {
            rankVals.put(RANKS[i], VALS[i]);
        }
    }

    private void dealHands() {
        d.shuffleCards();
        playHand.drawCardFrom(d, 2);
        compHand.drawCardFrom(d, 2);
        compHand.hideCards();
    }

    public Hand getPlayHand() {
        return playHand;
    }

    public Hand getCompHand() {
        return compHand;
    }

    public void playGame() {
        startGame();
        gamePlay();
        endGame();
    }

    private void gamePlay() {
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

        // If player hasn't lost, dealer has their turn.
        if (getHandValue(playHand) <= 21) {
            dealersTurn(compHand);
        }

        // Display final result.
        compHand.unhideCards();
        showTable();
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
        if (ans.equals("y")) {
            return true;
        } else if (ans.equals("n")) {
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
