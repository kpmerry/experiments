import java.util.Random;

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
        String[] winMessages = { "Well done player!", "You're on fire!", "Nice one!" };
        typingEffect("YOU WIN ");
        Random r = new Random();
        String winMessage = winMessages[r.nextInt(winMessages.length)];
        typingEffect(winMessage);
    }

    protected void loseGame() {
        String[] loseMessages = { "Better luck next time :(", "Try again!", "It was a good effort." };
        typingEffect("YOU LOSE ");
        Random r = new Random();
        String loseMessage = loseMessages[r.nextInt(loseMessages.length)];
        typingEffect(loseMessage);
    }

    protected void drawGame() {
        String[] drawMessages = { "Not too shabby, not too great.", "Looks like an even match" };
        typingEffect("YOU DRAW ");
        Random r = new Random();
        String drawMessage = drawMessages[r.nextInt(drawMessages.length)];
        typingEffect(drawMessage);
    }

    protected void pause(long ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {
        }
    }

    public void endGame() {
        typingEffect("\n ---- GAME OVER ---- \n");
        pause(1000);
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
