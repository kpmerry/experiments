import java.util.Random;

public class Dice {
    int sides;
    int sideFaceUp;

    public Dice() {
        sides = 6;
    }

    public Dice(int inSides) {
        sides = inSides;
    }

    public int roll() {
        int i;
        Random r = new Random();
        i = r.nextInt(sides) + 1;
        this.sideFaceUp = i;
        return i;
    }

    public String toString() {
        return "Dice : " + sideFaceUp;
    }
}