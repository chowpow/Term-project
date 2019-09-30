package ui;

import model.FantasyTeam;
import model.Team;
import model.Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class FantasyTeamTest {
    FantasyTeam testFantasyTeam = new FantasyTeam();

    Player player1;
    Player player2;
    Player player3;
    Player player4;

    Team testTeam;
    Team testTeam1;
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

        team1.addPlayer(player1);
        team1.addPlayer(player2);

        team2.addPlayer(player1);
        team2.addPlayer(player2);
        team2.addPlayer(player3);
        team2.addPlayer(player4);
    }

    @Test
    void testSave() throws IOException, ClassNotFoundException {
        testFantasyTeam.save(team1);
        ObjectInputStream testLoad = new ObjectInputStream(new FileInputStream("Save.txt"));
        testTeam = (Team) testLoad.readObject();
        assertEquals(team1.allPlayerNames(),testTeam.allPlayerNames());

        testFantasyTeam.save(team2);
        ObjectInputStream testLoad1 = new ObjectInputStream(new FileInputStream("Save.txt"));
        testTeam1 = (Team) testLoad1.readObject();
        assertEquals(team2.allPlayerNames(),testTeam1.allPlayerNames());



    }
}
