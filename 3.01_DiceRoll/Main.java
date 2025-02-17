public class Main {
    public static void main(String[] args) {
        int diceNo;
        if (args == null) {
            diceNo = 1;
        } else {
            diceNo = parseArgs(args);
        }
        rollHand(diceNo);
    }

    private static int parseArgs(String[] args) {
        int diceNo = 1;
        try {
            diceNo = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.out.println("No dice number data found - assuming 1 die.");
        }
        return diceNo;
    }

    private static void rollHand(int diceNo) {
        Hand h = new Hand(diceNo);
        h.roll();
        System.out.print(h);
    }
}
