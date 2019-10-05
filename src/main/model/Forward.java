package model;

public class Forward extends Player {
    public Forward(String playerName, String position, int goals, int assists) {
        super(playerName, position, goals, assists);
    }

    @Override
    public int calculatePoints() {
        points = (4 * goals) + (3 * assists);
        return points;
    }


}
