import java.util.ArrayList;

public class Hand extends CardContainer {
    protected String playerName;

    public Hand() {
        cards = new ArrayList<Card>();
    }

    public Hand(String inName) {
        playerName = inName;
    }

    public String toString() {
        return "< Hand : " + cards.size() + " >";
    }

    protected void setName(String inName) {
        playerName = inName;
    }

    protected String getName() {
        return playerName;
    }
}
