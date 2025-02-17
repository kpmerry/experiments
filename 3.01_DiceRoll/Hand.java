import java.util.ArrayList;

public class Hand {
    int size;
    ArrayList<Dice> diceInHand;

    public Hand(int inSize) {
        size = inSize;
        diceInHand = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Dice d = new Dice();
            diceInHand.add(d);
        }
    }

    public Hand() {
        size = 1;
        Dice d = new Dice();
        diceInHand.add(d);
    }

    public String toString() {
        String s = "";
        for (Dice d : diceInHand) {
            s += d.toString() + "\n";
        }
        return s;
    }

    public void roll() {
        for (Dice die : diceInHand) {
            die.roll();
        }
    }
}