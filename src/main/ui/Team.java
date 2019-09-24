import java.util.ArrayList;
import java.util.List;

public class Team {
    private List<Player> squad;

    public void makeTeam() {
        squad = new ArrayList<Player>();
    }

    public ArrayList<Player> getSquad() {
        return (ArrayList<Player>) squad;
    }

    public void addPlayer(Player player) {
        squad.add(player);
    }

    public void removePlayer(Player player) {
        squad.remove(player);
    }

    public List<String> allPlayerNames() {
        List<String> allPlayersInTeam = new ArrayList<String>();
        for (Player player : squad) {
            allPlayersInTeam.add(player.getPlayerName());
        }
        return allPlayersInTeam;
    }

    public int calculateTeamPoints() {
        int teamPoints = 0;
        for (Player player : squad) {
            teamPoints = teamPoints + player.calculatePoints();
        }
        return teamPoints;
    }
}