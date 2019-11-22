package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Player implements Serializable {
    private static final long serialVersionUID = 8710558539120338013L;
    protected String playerName;
    protected String position;
    protected int goals;
    protected int assists;
    protected int points;

    public Player(String playerName, String position, int goals, int assists) {
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
    public abstract int calculatePoints();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return playerName.equals(player.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName, position, goals, assists, points);
    }

    @Override
    public String toString() {
        return playerName;
    }
}
