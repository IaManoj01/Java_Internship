import java.util.Scanner;

public class NumberGuessingGame {
    private Scoreboard scoreboard;
    private Scanner scanner;

    public NumberGuessingGame() {
        this.scoreboard = new Scoreboard();
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            Round round = new Round(scoreboard);
            round.play();

            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Your final score is: " + scoreboard.getTotalScore());
        scanner.close();
    }

    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();
        game.startGame();
    }
}
