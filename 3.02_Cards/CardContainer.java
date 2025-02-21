import java.util.*;
import java.lang.StringBuffer;

abstract class CardContainer {
    protected ArrayList<Card> cards;

    protected void shuffleCards() {
        Collections.shuffle(cards);
    }

    public void revealCards() {
        StringBuffer s = new StringBuffer();
        for (Card c : cards) {
            s.append(new StringBuffer(c.toString()));
            s.append("\n");
        }
        System.out.println(s);
    }

    protected void addCard(Card c) {
        cards.add(c);
    }

    private Card removeCard() {
        try {
            Card c = cards.remove(cards.size() - 1);
            return c;
        } catch (Exception e) {
            System.out.println("Card not found");
            return null;
        }
    }

    protected void drawCardFrom(CardContainer cc) {
        Card drawnCard = cc.removeCard();
        addCard(drawnCard);
    }

    protected void dealCardTo(CardContainer cc) {
        Card movingCard = cards.remove(0);
        cc.addCard(movingCard);
    }

    protected void drawCardFrom(CardContainer cc, int num) {
        for (int i = 0; i < num; i++) {
            drawCardFrom(cc);
        }
    }

    protected void dealCardTo(CardContainer cc, int num) {
        for (int i = 0; i < num; i++) {
            dealCardTo(cc);
        }
    }

    protected void hideCards() {
        for (Card c : cards) {
            c.hidden = true;
        }
    }

    protected void unhideCards() {
        for (Card c : cards) {
            c.hidden = false;
        }
    }

}
