class BlackJackGame extends CardGame {
    Deck d;
    Hand compHand;
    Hand playHand;

    public BlackJackGame() {
        super("Black Jack");
        compHand = new Hand();
        playHand = new Hand();
    }
}
