class Card {
    protected String rank;
    protected String suit;
    protected Boolean hidden;

    public Card(String inRank, String inSuit) {
        rank = inRank;
        suit = inSuit;
        hidden = false;
    }

    public String toString() {
        if (hidden == true) {
            return "< --- hidden card --- >";
        }
        return "< " + suit + " : " + rank + " >";
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

}