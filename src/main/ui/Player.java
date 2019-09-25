public class Player {
    private String playerName;
    private String position;
    private int goals;
    private int assists;
    private int points;

    public void makePlayer(String playerName, String position, int goals, int assists) {
        this.playerName = playerName;
        this.position = position;
        this.goals = goals;
        this.assists = assists;
        points = 0;
    }
    // EFFECTS: returns the player's name
    public String getPlayerName() {
        return playerName;
    }

    // EFFECTS: returns the player's position
    public String getPosition() {
        return this.position;
    }

    // EFFECTS: returns how many goals the player scored
    public int getGoals() {
        return this.goals;
    }

    // EFFECTS: returns how many assists the player got
    public int getAssists() {
        return this.assists;
    }

    // MODIFIES: this
    // EFFECTS: returns how many points a player got
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
