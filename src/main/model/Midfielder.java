package model;

public class Midfielder extends Player {
    public Midfielder(String playerName, String position, int goals, int assists) {
        super(playerName, position, goals, assists);
    }

    // MODIFIES: this
    // EFFECTS: returns how many points a midfielder got
    @Override
    public int calculatePoints() {
        points = (5 * goals) + (3 * assists);
        return points;
    }
}
