package model;

import model.Player;

import java.io.*;
import java.util.*;

public class Team implements Serializable {
    private HashMap<String, Player> squad1;
    private int teamPoints;

    public Team() {
        squad1 = new HashMap<>();
    }

    // Retrieving all values from HashMap from https://stackoverflow.com/questions/12960265/retrieve-all-values-from-hashmap-keys-in-an-arraylist-java

    // EFFECTS: returns all the players in the team
    public Set<Player> getSquad() {
        Set<Player> squad = new HashSet<>();
        for (String key: squad1.keySet()) {
            squad.add(squad1.get(key));
        }
        return squad;
    }

    // EFFECTS: returns the player mapped by the key
    public Player getPlayer(String playerName) {
        return squad1.get(playerName);
    }

    // EFFECTS: returns size of squad
    public int sizeOfSquad() {
        return squad1.size();
    }

    // MODIFIES: this
    // EFFECTS: adds a player to the team, throws FantasyTeamFullException if more than 11 players
    public void addPlayer(Player player) throws FantasyTeamFullException {
        if (squad1.size() >= 11) {
            throw new FantasyTeamFullException();
        }
        squad1.put(player.playerName, player);
    }

    // MODIFIES: this
    // EFFECTS: removes a player from the team
    public void removePlayer(String playerName) {
        squad1.remove(playerName);
    }

    // EFFECTS: returns the names of all players in the team
    public Set<String> allPlayerNames() {
        Set<String> allPlayersInTeam = new HashSet<>();
        for (String key: squad1.keySet()) {
            allPlayersInTeam.add(squad1.get(key).playerName);
        }
        return allPlayersInTeam;
    }

    // MODIFIES: this
    // EFFECTS: returns the total points in a team
    public int calculateTeamPoints() {
        teamPoints = 0;
        for (String key: squad1.keySet()) {
            teamPoints += squad1.get(key).points;
        }
        return teamPoints;
    }
}