package ui;

import model.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FantasyTeamTest {
    FantasyTeam testFantasyTeam = new FantasyTeam();

    Player player1;
    Player player2;
    Player player3;
    Player player4;

    Team testTeam1;
    Team testTeam2;
    Team clearSave;
    Team team1;
    Team team2;

    @BeforeEach
    void runBefore() {
        player1 = new Forward("Mo Salah", "forward",2,2);
        player2 = new Midfielder("Paul Pogba","midfielder",1,1);
        player3 = new Defender("Virgil van Dijk","defender",1,0);
        player4 = new Goalkeeper("David de Gea","goalkeeper",0,0);

        team1 = new Team();
        team2 = new Team();

        team1.addPlayer(player1);

        team2.addPlayer(player1);
        team2.addPlayer(player2);
        team2.addPlayer(player3);
        team2.addPlayer(player4);

        clearSave = new Team();
    }


    @Test
    void testLoadAndSave() throws IOException, ClassNotFoundException {
        testFantasyTeam.save(team1);
        testTeam1 = testFantasyTeam.load();
        assertEquals(team1.allPlayerNames(), testTeam1.allPlayerNames());

        testFantasyTeam.save(team2);
        testTeam2 = testFantasyTeam.load();
        assertEquals(team2.allPlayerNames(), testTeam2.allPlayerNames());

        testFantasyTeam.save(clearSave);
    }
}
