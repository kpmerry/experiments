public class CardTest {
    public static void main(String[] args) {
        playBlackJack();
    }

    public static void playBlackJack() {
        BlackJackGame game = new BlackJackGame();
        game.playGame();
    }

    public static void testCards() {
        Deck d = new Deck();
        d.shuffleCards();
        Hand h1 = new Hand("Player 1");
        Hand h2 = new Hand("Player 2");
        for (int i = 0; i < 2; i++) {
            d.dealCardTo(h2);
            d.dealCardTo(h1);
        }
        h1.revealCards();
        h2.revealCards();
    }

    public static void fancyPrintTest() {
        Hand h = new Hand();
        Deck d = new Deck();
        d.shuffleCards();
        d.dealCardTo(h, 5);
        h.fancyPrint();
    }

}
