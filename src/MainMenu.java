import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(".------..------..------..------..------.       .------..------.");
        System.out.println("|K.--. ||N.--. ||O.--. ||C.--. ||K.--. | .-.   |3.--. ||1.--. |");
        System.out.println("| :/\\: || :(): || :/\\: || :/\\: || :/\\: |((5))  | :(): || :/\\: |");
        System.out.println("| :\\/| || ()() || :\\/| || :\\/| || :\\/| | '-.-. | ()() || (__) |");
        System.out.println("| '--'K|| '--'N|| '--'O|| '--'C|| '--'K|  ((1))| '--'3|| '--'1|");
        System.out.println("`------'`------'`------'`------'`------'   '-' `------'`------'");
        System.out.println();
        System.out.println("Do you want to play against:");
        System.out.println("  (1) Computer");
        System.out.println("  (2) Another player?");



        int choice = scanner.nextInt();

        Game game;

        if (choice == 1) {
            game = new Game(false);  // Pass false to indicate single-player mode (vs computer)
        } else if (choice == 2) {
            game = new Game(true);  // Pass true to indicate multiplayer mode
        } else {
            System.out.println("Invalid choice. Please choose 1 or 2.");
            return;
        }

        game.play();
    }
}
