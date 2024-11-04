import java.util.Scanner;

public class Round {
    private static final int MAX_ATTEMPTS = 10; // Maximum attempts allowed
    private GameLogic gameLogic;
    private Scoreboard scoreboard;
    private int attempts;

    public Round(Scoreboard scoreboard) {
        this.gameLogic = new GameLogic();
        this.scoreboard = scoreboard;
        this.attempts = 0;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean hasWon = false;

        System.out.println("New round started! Guess the number between 1 and 100.");

        while (attempts < MAX_ATTEMPTS && !hasWon) {
            System.out.print("\nEnter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            String result = gameLogic.checkGuess(guess);
            if (result.equals("Correct")) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                updateScore();
                hasWon = true;
            } else {
                System.out.println(result);
            }
        }

        if (!hasWon) {
            System.out.println("You've used all attempts! The correct number was " + gameLogic.getTargetNumber());
        }
    }

    private void updateScore() {
        int points;
        if (attempts <= 3) {
            points = 10;
        } else if (attempts <= 6) {
            points = 7;
        } else {
            points = 5;
        }
        scoreboard.addScore(points);
        System.out.println("You earned " + points + " points! Total Score: " + scoreboard.getTotalScore());
    }
}
