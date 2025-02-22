public class CardGame {
    protected String gameName;

    public CardGame(String inName) {
        gameName = inName;
    }

    public void startGame() {
        System.out.print("\n");
        typingEffect(" ---- GAME START ---- ");
        System.out.print("\n");
    }

    protected void winGame() {
        typingEffect("YOU WIN ");
        typingEffect("Well done player!");
    }

    protected void loseGame() {
        typingEffect("YOU LOSE ");
        typingEffect("Better luck next time :(");
    }

    protected void drawGame() {
        typingEffect("YOU DRAW ");
        typingEffect("Seems like you're on par today!");
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
        // Print each single-letter substring with delay.
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.substring(i, i + 1));
            pause(40);
        }
        System.out.print("\n");
    }
}
