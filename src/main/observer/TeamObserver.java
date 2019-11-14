package observer;

import model.Player;
import model.Team;

import java.util.Observable;
import java.util.Observer;

public class TeamObserver implements Observer {
    private int numOfPlayers = 0;

    public TeamObserver() {
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Player added: " + arg);
        System.out.println("Number of players: " + getNumOfPlayers());
    }

    public void update(String name) {
        System.out.println("Player removed: " + name);
        System.out.println("Number of players: " + getNumOfPlayers());
    }

    public void addPlayerNumber() {
        numOfPlayers++;
    }

    public void subtractPlayerNumber() {
        numOfPlayers--;
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }
}
