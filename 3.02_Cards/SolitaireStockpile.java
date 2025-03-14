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
            wastePileCards.addCard(cards.remove(i));
        }
    }

    public void revealStockPile() {
        wastePileCards.condensedFancyPrint();
        System.out.println("\n");
    }
}
