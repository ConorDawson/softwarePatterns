import java.util.Scanner;

public class Game {
    private Deck deck;
    private Player player1;
    private Player player2;
    private boolean multiplayerMode;
    private boolean player1Knocked = false;
    private boolean player2Knocked = false;
    private Scanner scanner = new Scanner(System.in);

    public Game(boolean multiplayerMode) {
        this.multiplayerMode = multiplayerMode;
        deck = new Deck();
        player1 = new Player("Player 1", deck);

        if (multiplayerMode) {
            player2 = new Player("Player 2", deck);  // Player 2 is another human
        } else {
            player2 = new Player("Computer", deck);  // Player 2 is the computer
        }
    }

    // Main game loop
    public void play() {
        while (!player1Knocked && !player2Knocked) {
            player1Turn();
            if (!player1Knocked) {
                player2Turn();
            }
        }
        endRound();
    }

    // Player 1's turn
    private void player1Turn() {
        System.out.println("Player 1's hand:");
        player1.printHandInAscii();  // Display ASCII representation of the hand

        System.out.println("Player 1, do you want to (1) draw a card or (2) knock?");
        int choice = scanner.nextInt();

        if (choice == 1) {
            player1.drawCard();
            System.out.println("Player 1 drew a card.");
        } else if (choice == 2) {
            if (player1.canKnock()) {
                player1Knocked = true;
                System.out.println("Player 1 knocked.");
            } else {
                System.out.println("Player 1 cannot knock yet. Your score is too low.");
            }
        }
    }

    // Player 2's turn (can be human or computer)
    private void player2Turn() {
        if (multiplayerMode) {
            System.out.println("Player 2's hand:");
            player2.printHandInAscii();  // Display ASCII representation of the hand

            System.out.println("Player 2, do you want to (1) draw a card or (2) knock?");
            int choice = scanner.nextInt();

            if (choice == 1) {
                player2.drawCard();
                System.out.println("Player 2 drew a card.");
            } else if (choice == 2) {
                if (player2.canKnock()) {
                    player2Knocked = true;
                    System.out.println("Player 2 knocked.");
                } else {
                    System.out.println("Player 2 cannot knock yet. Your score is too low.");
                }
            }
        } else {
            // Player 2 is the computer
            System.out.println("Computer's turn.");
            if (player2.getBestSuitScore() >= 25) {
                player2Knocked = true;
                System.out.println("Computer knocked.");
            } else {
                System.out.println("Computer discarded the worst card and drew a new one.");
                player2.discardWorstCard(); // Discard the worst card
                player2.drawCard();  // Draw a new card
            }
        }
    }

    // End of the round, check the scores
    private void endRound() {
        int player1Score = player1.getBestSuitScore();
        int player2Score = player2.getBestSuitScore();

        System.out.println("Player 1's score: " + player1Score);
        System.out.println("Player 2's score: " + player2Score);

        if (player1Score > player2Score) {
            System.out.println("Player 1 wins!");
        } else if (player2Score > player1Score) {
            System.out.println((multiplayerMode ? "Player 2" : "Computer") + " wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
