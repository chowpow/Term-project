package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Player implements Serializable {
    protected String playerName;
    protected String position;
    protected int goals;
    protected int assists;
    protected int points;
    protected List<Match> matches;

    public Player(String playerName, String position, int goals, int assists) {
        this.playerName = playerName;
        this.position = position;
        this.goals = goals;
        this.assists = assists;
        points = 0;
        matches = new ArrayList<>();
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
    public abstract int calculatePoints();

    // MODIFIES: this
    // EFFECTS: adds player to Match m and adds Match m to this
    public void addMatch(Match m) {
        if (!matches.contains(m)) {
            matches.add(m);
            m.addPlayer(this);
        }
    }
}
