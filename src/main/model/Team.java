package model;

import observer.TeamObserver;

import java.io.*;
import java.util.*;

public class Team extends Observable implements Serializable {
    private static final long serialVersionUID = 3975000037569581182L;
    private HashMap<String, Player> squad;
    private int teamPoints;
    private Boolean isAddingPlayer;
    //private TeamObserver teamObserver = new TeamObserver();

    public Team() {
        squad = new HashMap<>();
    }

    // Retrieving all values from HashMap from https://stackoverflow.com/questions/12960265/retrieve-all-values-from-hashmap-keys-in-an-arraylist-java

    // EFFECTS: returns all the players in the team
    public Set<Player> getSquad() {
        Set<Player> squad = new HashSet<>();
        for (String key: this.squad.keySet()) {
            squad.add(this.squad.get(key));
        }
        return squad;
    }

    // EFFECTS: returns the player mapped by the key
    public Player getPlayer(String playerName) {
        return squad.get(playerName);
    }

    // EFFECTS: returns size of squad
    public int sizeOfSquad() {
        return squad.size();
    }

    // MODIFIES: this
    // EFFECTS: adds a player to the team, throws FantasyTeamFullException if more than 11 players
    public void addPlayer(Player player) throws FantasyTeamFullException {
        if (squad.size() >= 11) {
            throw new FantasyTeamFullException();
        }
        squad.put(player.getPlayerName(), player);
        isAddingPlayer = true;
        setChanged();
        notifyObservers(player.getPlayerName());
    }

    // MODIFIES: this
    // EFFECTS: removes a player from the team
    public void removePlayer(String playerName) {
        squad.remove(playerName);
        isAddingPlayer = false;
        setChanged();
        notifyObservers(playerName);
    }

    // EFFECTS: returns the names of all players in the team
    public Set<String> allPlayerNames() {
        Set<String> allPlayersInTeam = new HashSet<>();
        for (String key: squad.keySet()) {
            allPlayersInTeam.add(squad.get(key).getPlayerName());
        }
        return allPlayersInTeam;
    }

    // MODIFIES: this
    // EFFECTS: returns the total points in a team
    public int calculateTeamPoints() {
        teamPoints = 0;
        for (String key: squad.keySet()) {
            teamPoints += squad.get(key).calculatePoints();
        }
        return teamPoints;
    }

    // EFFECTS: returns whether a player is being added or removed
    public Boolean getAddingPlayer() {
        return isAddingPlayer;
    }
}

