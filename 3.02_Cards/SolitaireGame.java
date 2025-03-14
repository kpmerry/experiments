import java.util.ArrayList;
import java.util.Scanner;

public class SolitaireGame extends CardGame implements StandardDeck {
    private Deck d;
    private Scanner in;
    private long speed;
    private SolitaireColumn hearts;
    private SolitaireColumn spades;
    private SolitaireColumn diamonds;
    private SolitaireColumn clubs;
    private SolitaireColumn col1;
    private SolitaireColumn col2;
    private SolitaireColumn col3;
    private SolitaireColumn col4;
    private SolitaireColumn col5;
    private SolitaireColumn col6;
    private SolitaireColumn col7;
    private SolitaireStockpile stockpile;

    public SolitaireGame() {
        super("Solitaire");
        speed = 500;

        // Create new instances for the game parts.
        d = new Deck();
        in = new Scanner(System.in);
        clubs = new SolitaireColumn(); // TODO create new class.
        hearts = new SolitaireColumn();
        spades = new SolitaireColumn();
        diamonds = new SolitaireColumn();
        stockpile = new SolitaireStockpile();

        col1 = new SolitaireColumn(1);
        col2 = new SolitaireColumn(2);
        col3 = new SolitaireColumn(3);
        col4 = new SolitaireColumn(4);
        col5 = new SolitaireColumn(5);
        col6 = new SolitaireColumn(6);
        col7 = new SolitaireColumn(7);

        // Deal out the cards to the correct columns.
        dealSolitaireColumns();
    }

    private void dealSolitaireColumns() {
        d.shuffleCards();
        d.dealCardTo(col2, 1);
        d.dealCardTo(col3, 2);
        d.dealCardTo(col4, 3);
        d.dealCardTo(col5, 4);
        d.dealCardTo(col6, 5);
        d.dealCardTo(col7, 6);
        col2.hideCards();
        col3.hideCards();
        col4.hideCards();
        col5.hideCards();
        col6.hideCards();
        col7.hideCards();
        d.dealCardTo(col1);
        d.dealCardTo(col2);
        d.dealCardTo(col3);
        d.dealCardTo(col4);
        d.dealCardTo(col5);
        d.dealCardTo(col6);
        d.dealCardTo(col7);
        d.dealCardTo(stockpile, d.cards.size());
    }

    public void gamePlay() {
        startGame();
        showBoard();
        showBoard();
    }

    public void showBoard() {
        // Show cards in the columns.
        pause(speed);
        turnCard();
        stockpile.revealStockPile();
        SolitaireColumn[] cols = { col1, col2, col3, col4, col5, col6, col7 };
        ArrayList<ArrayList<String>> colStrings = new ArrayList<>();
        for (SolitaireColumn col : cols) {
            colStrings.add(col.getFancyPrintColumn());
        }
        for (int i = 0; i < 20; i++) {
            for (ArrayList<String> s : colStrings) {
                try {
                    System.out.print(s.get(i) + "  ");
                } catch (Exception e) {
                    System.out.print(" ".repeat(17));
                }
            }
            System.out.print("\n");
        }
        System.out.println("");
    }

    public void turnCard() {
        stockpile.turnCards();
    }
}
