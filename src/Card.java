public class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    // Get the value of the card for scoring purposes (Aces = 11, Face cards = 10, others = face value)
    public int getValue() {
        switch (rank) {

            default:
                return rank.getValue();
        }
    }

    // Returns an ASCII art representation of the card
    public String toArt() {
        String rankDisplay = rankToString(rank);
        String suitDisplay = suitToSymbol(suit);

        // Creating a simple ASCII representation of the card
        return String.format(
                "+-----+\n" +
                        "|%-2s   |\n" +  // Left-aligned rank
                        "|  %s  |\n" +   // Suit symbol in the middle
                        "|   %-2s|\n" +  // Right-aligned rank
                        "+-----+",
                rankDisplay, suitDisplay, rankDisplay
        );
    }

    // Convert rank to a string for display
    private String rankToString(Rank rank) {
        switch (rank) {
            case ACE:
                return "A";
            case KING:
                return "K";
            case QUEEN:
                return "Q";
            case JACK:
                return "J";
            default:
                return String.valueOf(rank.getValue());  // For numbers 2-10
        }
    }

    // Convert suit to a symbol for display
    private String suitToSymbol(Suit suit) {
        switch (suit) {
            case HEARTS:
                return "♥";
            case DIAMONDS:
                return "♦";
            case CLUBS:
                return "♣";
            case SPADES:
                return "♠";
            default:
                return "?";
        }
    }

    // Provide a readable string representation of the card (e.g., "ACE of SPADES")
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
