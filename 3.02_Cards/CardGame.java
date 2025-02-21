public class CardGame {
    protected String gameName;

    public CardGame(String inName) {
        gameName = inName;
    }

    public void startGame() {
        System.out.printf(" ---- %s START ---- \n", gameName);
    }

    public void endGame() {
        System.out.println(" ---- GAME OVER ---- ");
    }
}
