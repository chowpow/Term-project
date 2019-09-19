import java.util.ArrayList;
import java.util.List;

public class Team {
    private List<Player> squad;

    public void makeTeam() {
        squad = new ArrayList<Player>();
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
        return  allPlayersInTeam;
    }
}
