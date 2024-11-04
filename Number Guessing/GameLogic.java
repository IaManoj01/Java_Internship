import java.util.Random;

public class GameLogic {
    private int targetNumber;
    private static final int NUMBER_RANGE = 100;

    public GameLogic() {
        Random random = new Random();
        this.targetNumber = random.nextInt(NUMBER_RANGE) + 1; // Random number between 1 and 100
    }

    public int getTargetNumber() {
        return targetNumber;
    }

    public String checkGuess(int guess) {
        if (guess < targetNumber) {
            return "Too low! Try again.";
        } else if (guess > targetNumber) {
            return "Too high! Try again.";
        } else {
            return "Correct";
        }
    }
}
