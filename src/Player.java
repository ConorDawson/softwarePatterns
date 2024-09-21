import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private String name;
    private List<Card> hand;
    private Deck deck;
    private Scanner scanner = new Scanner(System.in);

    // Constructor to initialize player and deal 3 cards
    public Player(String name, Deck deck) {
        this.name = name;
        this.deck = deck;
        hand = new ArrayList<>();
        drawInitialHand();
    }

    // Draw initial hand of 3 cards
    private void drawInitialHand() {
        for (int i = 0; i < 3; i++) {
            hand.add(deck.dealCard());
        }
    }

    // Draw a card from the deck
    public void drawCard() {
        hand.add(deck.dealCard());
        // After drawing, the player must discard to keep only 3 cards
        discardCard(chooseCardToDiscard());
    }

    // Method to discard a card chosen by the player
    public void discardCard(Card card) {
        hand.remove(card);
        System.out.println(name + " discarded: " + card);
    }

    // Allow the player to choose which card to discard
    public Card chooseCardToDiscard() {
        // Display the hand with index numbers
        System.out.println(name + "'s hand:");
        printHandInAscii(); // Displays the hand with ASCII art

        // Prompt the player to select a card to discard
        int choice = -1;
        while (choice < 1 || choice > hand.size()) {
            System.out.print("Choose a card to discard (1-" + hand.size() + "): ");
            choice = scanner.nextInt();
        }

        // Return the chosen card (adjusting index for zero-based list)
        return hand.get(choice - 1);
    }

    // Get the highest score in any one suit
    public int getBestSuitScore() {
        int hearts = 0, diamonds = 0, clubs = 0, spades = 0;

        for (Card card : hand) {
            switch (card.getSuit()) {
                case HEARTS: hearts += card.getValue(); break;
                case DIAMONDS: diamonds += card.getValue(); break;
                case CLUBS: clubs += card.getValue(); break;
                case SPADES: spades += card.getValue(); break;
            }
        }

        return Math.max(Math.max(hearts, diamonds), Math.max(clubs, spades));
    }

    // Check if the player can knock
    public boolean canKnock() {
        return getBestSuitScore() >= 20; // Can knock if score is 20 or more
    }

    public List<Card> getHand() {
        return hand;
    }

    public void printHandInAscii() {
        // Arrays to hold each line of the ASCII art for all cards
        String[] cardLines = new String[5]; // Each card has 5 lines in its ASCII art

        // Initialize the cardLines array
        for (int i = 0; i < cardLines.length; i++) {
            cardLines[i] = "";
        }

        // Build the card art line by line
        for (Card card : hand) {
            String[] cardArt = card.toArt().split("\n");
            for (int i = 0; i < cardArt.length; i++) {
                cardLines[i] += cardArt[i] + "   ";  // Add some space between cards
            }
        }

        // Print each line of the cards horizontally
        for (String line : cardLines) {
            System.out.println(line);
        }
    }

    public void discardWorstCard() {
        Card worstCard = null;
        int worstContribution = Integer.MAX_VALUE;

        // Find the card with the least contribution to the best suit score
        for (Card card : hand) {
            int contribution = getSuitScoreContribution(card);
            if (contribution < worstContribution) {
                worstContribution = contribution;
                worstCard = card;
            }
        }

        // Remove the worst card from the hand
        if (worstCard != null) {
            hand.remove(worstCard);
            System.out.println(name + " discarded " + worstCard);
        }
    }

    // This helper method calculates how much a card contributes to the best suit score
    private int getSuitScoreContribution(Card card) {
        int suitScore = 0;

        // Calculate the score of the card based on its suit value (e.g., Ace = 11)
        for (Card c : hand) {
            if (c.getSuit() == card.getSuit()) {
                suitScore += c.getValue();  // Add the value of cards of the same suit
            }
        }

        return suitScore;
    }



    @Override
    public String toString() {
        return name + "'s hand: " + hand.toString();
    }
}
