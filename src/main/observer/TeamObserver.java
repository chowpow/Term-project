package observer;

import model.Player;
import model.Team;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

public class TeamObserver implements Observer, Serializable {
    private static final long serialVersionUID = -7174921117812656604L;
    private int numOfPlayers = 0;

    public TeamObserver() {
    }

    @Override
    public void update(Observable o, Object arg) {
        Team team = (Team) o;
        if (team.getAddingPlayer()) {
            System.out.println("Player added: " + arg);
            numOfPlayers++;
        } else {
            System.out.println("Player removed: " + arg);
            numOfPlayers--;
        }
        System.out.println("Number of players: " + numOfPlayers);
    }

    // MODIFIES: this
    // EFFECTS: sets the number of players
    public void setNumOfPlayers(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }
}
