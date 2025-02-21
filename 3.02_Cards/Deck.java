import java.util.ArrayList;

public class Deck extends CardContainer {
    public Deck() {
        cards = new ArrayList<Card>();
        final String[] RANKS = { "A", "1", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K" };
        final String[] SUITS = { "Clubs", "Spades", "Diamonds", "Hearts" };
        for (String s : SUITS) {
            for (String r : RANKS) {
                Card c = new Card(r, s);
                addCard(c);
            }
        }
    }

    public String toString() {
        return "< Deck " + cards.size() + " >";
    }
}
