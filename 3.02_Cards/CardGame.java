public class CardGame {
    protected String gameName;

    public CardGame(String inName) {
        gameName = inName;
    }

    public void startGame() {
        System.out.printf("\n%s\n ---- GAME START ---- \n\n", gameName);
    }

    protected void winGame() {
        typingEffect("\nYOU WIN\nWell done player!");
    }

    protected void loseGame() {
        typingEffect("\nYOU LOSE\nBetter luck next time :(");
    }

    protected void drawGame() {
        typingEffect("\nYOU DRAW\nSeems like you're on par with the comp today!");
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
        for (int i = 0; i < s.length() - 1; i++) {
            System.out.print(s.substring(i, i + 1));
            pause(40);
        }
        System.out.print("\n");
    }
}
