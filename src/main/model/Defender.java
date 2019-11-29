package model;

public class Defender extends Player {
    public Defender(String playerName, String position, int goals, int assists) {
        super(playerName, position, goals, assists);
    }

    // MODIFIES: this
    // EFFECTS: returns how many points a defender got
    @Override
    public int calculatePoints() {
        points = (6 * goals) + (3 * assists);
        return points;
    }
}
