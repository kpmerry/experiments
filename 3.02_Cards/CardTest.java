public class CardTest {
    public static void main(String[] args) {
        Deck d = new Deck();
        Hand h = new Hand();
        d.shuffleCards();
        System.out.println(d);
        System.out.println(h);
        h.drawCardFrom(d, 3);
        h.revealCards();
    }

}
