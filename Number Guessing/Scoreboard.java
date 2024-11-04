public class Scoreboard {
    private int totalScore;

    public Scoreboard() {
        this.totalScore = 0;
    }

    public void addScore(int points) {
        totalScore += points;
    }

    public int getTotalScore() {
        return totalScore;
    }
}
