package model;

public class Goalkeeper extends Player {

    public Goalkeeper(String playerName, String position, int goals, int assists) {
        super(playerName, position, goals, assists);
    }

    // MODIFIES: this
    // EFFECTS: returns how many points a goalkeeper got
    @Override
    public int calculatePoints() {
        points = (6 * goals) + (3 * assists);
        return points;
    }
}
