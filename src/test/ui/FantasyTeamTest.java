package ui;

import model.FantasyTeam;
import model.Team;
import model.Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class FantasyTeamTest {
    FantasyTeam testFantasyTeam = new FantasyTeam();

    Player player1;
    Player player2;
    Player player3;
    Player player4;

    Team team1;
    Team team2;
    Team team3;



    @BeforeEach
    void runBefore() {
        player1 = new Player("Mo Salah", "forward",2,2);
        player2 = new Player("Paul Pogba","midfielder",1,1);
        player3 = new Player("Virgil van Dijk","defender",1,0);
        player4 = new Player("David de Gea","goalkeeper",0,0);

        team1 = new Team();
        team2 = new Team();
        team3 = new Team();
    }

    @Test
    void testSave() {

    }
}
