import java.util.ArrayList;

public class Hand extends CardContainer {
    protected String playerName;

    public Hand() {
        cards = new ArrayList<Card>();
    }

    public Hand(String inName) {
        init();
        playerName = inName;
    }

    protected void init() {
        cards = new ArrayList<Card>();
    }

    public String toString() {
        return "< Hand : " + cards.size() + " >";
    }

    // Player name setter and getter.

    protected void setName(String inName) {
        playerName = inName;
    }

    protected String getName() {
        return playerName;
    }

    public void fancyPrint() {
        // Print cards with a nice visual.
        StringBuffer s = new StringBuffer();
        try {
            s.append("\t" + playerName + "\n");
        } catch (Exception e) {
        }
        s.append("++===========++  ".repeat(cards.size()));
        s.append("\n");
        for (Card c : cards) {
            if (c.hidden == true) {
                s.append("||   hidden  ||  ");
            } else {
                s.append("||     ");
                s.append(c.getRank());
                s.append(" ".repeat(6 - c.getRank().length()));
                s.append("||  ");
            }
        }
        s.append("\n");
        for (Card c : cards) {
            if (c.hidden == true) {
                s.append("||   hidden  ||  ");
            } else {
                String suit = c.getSuit();
                s.append("||  ");
                s.append(suit);
                s.append(" ".repeat(9 - suit.length()));
                s.append("||  ");
            }
        }
        s.append("\n");
        s.append("||           ||  ".repeat(cards.size()));
        s.append("\n");
        s.append("||           ||  ".repeat(cards.size()));
        s.append("\n");
        s.append("||           ||  ".repeat(cards.size()));
        s.append("\n");
        s.append("++===========++  ".repeat(cards.size()));
        s.append("\n");
        System.out.print(s);
    }
}
