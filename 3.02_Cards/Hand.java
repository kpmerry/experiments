import java.util.ArrayList;

public class Hand extends CardContainer {
    protected String playerName;

    public Hand() {
        init();
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
        // Print cards with a nice visual in a row.
        StringBuffer s = new StringBuffer();
        int len = cards.size();
        try {
            s.append("\t" + playerName + "\n");
        } catch (Exception e) {
        }
        s.append("++===========++  ".repeat(len));
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
        for (int i = 0; i < 3; i++) {
            s.append("\n");
            s.append("||           ||  ".repeat(len));
        }
        s.append("\n");
        s.append("++===========++  ".repeat(len));
        s.append("\n");
        System.out.print(s);
    }

    public void condensedFancyPrint() {
        int len = cards.size();
        // Print cards in a row with condensed format.
        StringBuffer s = new StringBuffer();
        try {
            s.append("\t" + playerName + "\n");
        } catch (Exception e) {
        }
        s.append("++==========".repeat(len));
        s.append("++");
        s.append("\n");
        for (Card c : cards) {
            if (c.hidden == true) {
                s.append("||   hidden ");
            } else {
                s.append("||     ");
                s.append(c.getRank());
                s.append(" ".repeat(5 - c.getRank().length()));
            }
        }
        s.append("||");
        s.append("\n");
        for (Card c : cards) {
            if (c.hidden == true) {
                s.append("||   hidden ");
            } else {
                String suit = c.getSuit();
                s.append("||  ");
                s.append(suit);
                s.append(" ".repeat(8 - suit.length()));
            }
        }
        s.append("||");
        for (int i = 0; i < 3; i++) {
            s.append("\n");
            s.append("||          ".repeat(len));
            s.append("||");
        }
        s.append("\n");
        s.append("++==========".repeat(len));
        s.append("++");
        s.append("\n");
        System.out.print(s);
    }
}
