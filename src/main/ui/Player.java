public class Player {
    private String playerName;
    private String position;
    private int goals;
    private int assists;
    private int points;

    public void makeplayer(String playerName, String position, int goals, int assists) {
        this.playerName = playerName;
        this.position = position;
        this.goals = goals;
        this.assists = assists;
        points = 0;
    }

    public void playerScore(String playerName, String position, int goals, int assists) {
        this.playerName = playerName;
        this.position = position;
        this.goals = goals;
        this.assists = assists;
        points = calculatePoints();
        System.out.println(playerName + " scored" + points + " this week!");
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public String getPosition() {
        return this.position;
    }

    public int getGoals() {
        return this.goals;
    }

    public int getAssists() {
        return this.assists;
    }

    public int calculatePoints() {
        points = 4 * this.goals + 3 * this.assists;
        return points;
    }
}
