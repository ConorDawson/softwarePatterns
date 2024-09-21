public class ScoreCheck {
    public static void compareScores(Player player, Player computer) {
        int playerScore = player.getBestSuitScore();
        int computerScore = computer.getBestSuitScore();

        System.out.println("Player's score: " + playerScore);
        System.out.println("Computer's score: " + computerScore);

        if (playerScore > computerScore) {
            System.out.println("Player wins!");
        } else if (computerScore > playerScore) {
            System.out.println("Computer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
