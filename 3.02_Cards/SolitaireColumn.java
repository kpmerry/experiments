import java.util.ArrayList;

public class SolitaireColumn extends CardContainer {
    private int columnIdentifier;

    public SolitaireColumn(int inColumnIdentifier) {
        cards = new ArrayList<>();
        columnIdentifier = inColumnIdentifier;
    }

    public String toString() {
        return "< Col : " + cards.size() + " >";
    }

    public int getColumnId() {
        return columnIdentifier;
    }

    public ArrayList<String> getFancyPrintColumn() {
        ArrayList<String> strings = new ArrayList<>();
        for (Card c : cards) {
            strings.add("++===========++");
            if (c.hidden == true) {
                strings.add("||   hidden  ||");
                continue;
            }
            strings.add("||           ||");
            strings.add("||     " + c.getRank() + " ".repeat(6 - c.getRank().length()) + "||");
            strings.add("||  " + c.getSuit() + " ".repeat(9 - c.getSuit().length()) + "||");
            if (cards.get(cards.size() - 1) == c) {
                strings.add("||           ||");
                strings.add("||           ||");
                strings.add("||           ||");
                strings.add("++===========++");
            }
        }
        return strings;
    }

    public void printSingleColumn() {
        ArrayList<String> linesToPrint = getFancyPrintColumn();
        for (String line : linesToPrint) {
            System.out.println(line);
        }
    }
}
