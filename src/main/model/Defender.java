package model;

public class Defender extends Player {
    public Defender(String playerName, String position, int goals, int assists) {
        super(playerName, position, goals, assists);
    }

    @Override
    public int calculatePoints() {
        points = (6 * goals) + (3 * assists);
        return points;
    }
}
