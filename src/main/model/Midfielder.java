package model;

public class Midfielder extends Player {
    public Midfielder(String playerName, String position, int goals, int assists) {
        super(playerName, position, goals, assists);
    }

    @Override
    public int calculatePoints() {
        points = (5 * goals) + (3 * assists);
        return points;
    }
}
