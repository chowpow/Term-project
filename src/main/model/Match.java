package model;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private String matchName;
    protected List<Player> players;

    public Match(String matchName) {
        this.matchName = matchName;
        players = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds a match to player p and adds player p to this
    public void addPlayer(Player p) {
        if (!players.contains(p)) {
            players.add(p);
            p.addMatch(this);
        }
    }
}
