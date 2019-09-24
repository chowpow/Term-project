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
        if (position.equals("forward")) {
            points = (4 * goals) + (3 * assists);
        } else if (position.equals("midfield")) {
            points = (5 * goals) + (3 * assists);
        } else {
            points = (6 * goals) + (3 * assists);
        }
        return points;
    }
}
