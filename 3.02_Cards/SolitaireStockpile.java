import java.util.ArrayList;

public class SolitaireStockpile extends CardContainer implements StandardDeck {
    private Hand wastePileCards;

    public SolitaireStockpile() {
        cards = new ArrayList<>();
        wastePileCards = new Hand("Wastepile");
    }

    public void turnCards() {
        if (wastePileCards.cards.size() > 0) {
            wastePileCards.hideCards();
        }
        for (int i = 0; i < 3; i++) {
            try {
                wastePileCards.addCard(cards.remove(i));
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
    }

    public void revealStockPile() {
        Hand shownCards = new Hand("Wastepile");
        for (Card c : wastePileCards.cards) {
            if (!c.hidden) {
                shownCards.addCard(c);
            }
        }
        shownCards.condensedFancyPrint();
        System.out.println("\n");
        for (Card c : shownCards.cards) {
            this.cards.add(c);
        }
        wastePileCards.unhideCards();
    }
}
