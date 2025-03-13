import java.util.ArrayList;
import java.util.Scanner;

public class SolitaireGame extends CardGame implements StandardDeck {
    private Deck d;
    private Scanner in;
    private long speed;
    private Hand col1;
    private Hand col2;
    private Hand col3;
    private Hand col4;
    private Hand col5;
    private Hand col6;
    private Hand col7;

    public SolitaireGame() {
        super("Solitaire");
        d = new Deck();
        in = new Scanner(System.in);
        speed = 500;
        col1 = new Hand("Column 1");
        col2 = new Hand("Column 2");
        col3 = new Hand("Column 3");
        col4 = new Hand("Column 4");
        col5 = new Hand("Column 5");
        col6 = new Hand("Column 6");
        col7 = new Hand("Column 7");
        dealHands();
    }

    private void dealHands() {
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
    }

    public void showBoard() {
        Hand[] cols = { col1, col2, col3, col4, col5, col6, col7 };
        for (Hand h : cols) {
            h.fancyPrint();
        }

    }
}
