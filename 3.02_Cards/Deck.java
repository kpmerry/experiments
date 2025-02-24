import java.util.ArrayList;

public class Deck extends CardContainer implements StandardDeck {
    public Deck() {
        cards = new ArrayList<Card>();
        for (String s : SUITS) {
            for (String r : RANKS) {
                Card c = new Card(r, s);
                addCard(c);
            }
        }
    }

    public String toString() {
        return "< Deck : " + cards.size() + " >";
    }
}
