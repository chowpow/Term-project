import java.util.ArrayList;
import java.util.List;

public class Team {
    private List<Player> squad;
    private int teamPoints;

    public void makeTeam() {
        squad = new ArrayList<>();
        teamPoints = 0;
    }

    // EFFECTS: returns all the players in the team
    public ArrayList<Player> getSquad() {
        return (ArrayList<Player>) squad;
    }

    // MODIFIES: this
    // EFFECTS: adds a player to the team
    public void addPlayer(Player player) {
        squad.add(player);
    }

    // MODIFIES: this
    // EFFECTS: removes a player from the team
    public void removePlayer(Player player) {
        squad.remove(player);
    }

    // EFFECTS: returns the names of all players in the team
    public List<String> allPlayerNames() {
        List<String> allPlayersInTeam = new ArrayList<String>();
        for (Player player : squad) {
            allPlayersInTeam.add(player.getPlayerName());
        }
        return allPlayersInTeam;
    }

    // MODIFIES: this
    // EFFECTS: returns the total points in a team
    public int calculateTeamPoints() {
        for (Player player : squad) {
            teamPoints = teamPoints + player.calculatePoints();
        }
        return teamPoints;
    }
}