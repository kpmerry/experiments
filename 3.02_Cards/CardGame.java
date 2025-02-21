public class CardGame {
    protected String gameName;

    public CardGame(String inName) {
        gameName = inName;
    }

    public void startGame() {
        System.out.print("\n");
        typingEffect(" ---- GAME START ---- ");
        // System.out.printf("\n%s\n\n\n", gameName);
    }

    protected void winGame() {
        typingEffect("\nYOU WIN\nWell done player! ");
    }

    protected void loseGame() {
        typingEffect("\nYOU LOSE\nBetter luck next time :( ");
    }

    protected void drawGame() {
        typingEffect("\nYOU DRAW\nSeems like you're on par with the comp today! ");
    }

    protected void pause(long ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {
        }
    }

    public void endGame() {
        System.out.println("\n ---- GAME OVER ---- \n");
    }

    protected void typingEffect(String s) {
        for (int i = 1; i < s.length(); i++) {
            System.out.print(s.substring(i - 1, i));
            pause(40);
        }
        System.out.print("\n");
    }
}
