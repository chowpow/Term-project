package ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {
    Team team1;
    Team team2;
    Team team3;
    Team team4 = new Team();
    Team team5 = new Team();

    Player player1;
    Player player2;
    Player player3;
    Player player4;

    ArrayList<Player> playerList;
    ArrayList<Player> playerList1;
    ArrayList<String> playerNameList;

    int teamScore;

    @BeforeEach
    void runBefore() {
        player1 = new Player("Mo Salah", "forward",2,2);
        player2 = new Player("Paul Pogba","midfielder",1,1);
        player3 = new Player("Virgil van Dijk","defender",1,0);
        player4 = new Player("David de Gea","goalkeeper",0,0);

        team1 = new Team();
        team2 = new Team();
        team3 = new Team();

        playerList = new ArrayList<Player>();
        playerList1 = new ArrayList<Player>();
        playerNameList = new ArrayList<String>();

        teamScore = 0;
    }

    @Test
    void testGetSquad() {
        Collections.addAll(playerList, player1, player2);
        Collections.addAll(playerList1,player1,player2,player3,player4);
        team2.addPlayer(player1);
        team2.addPlayer(player2);

        assertTrue(team1.getSquad().isEmpty());
        assertEquals(team2.getSquad(),playerList);

        team3.addPlayer(player1);
        team3.addPlayer(player2);
        team3.addPlayer(player3);
        team3.addPlayer(player4);

        assertEquals(team3.getSquad(),playerList1);
    }

    @Test
    void testAddPlayer() {
        team1.addPlayer(player1);
        assertFalse(team1.getSquad().isEmpty());

        team2.addPlayer(player1);
        team2.addPlayer(player2);

        assertTrue(team2.getSquad().contains(player1));
        assertTrue(team2.getSquad().contains(player2));

        team3.addPlayer(player1);
        team3.addPlayer(player2);
        team3.addPlayer(player3);
        team3.addPlayer(player4);

        assertTrue(team3.getSquad().contains(player3));
        assertTrue(team3.getSquad().contains(player1));
    }

    @Test
    void testRemovePlayer() {
        team1.removePlayer(player1);
        assertTrue(team1.getSquad().isEmpty());

        team2.addPlayer(player1);
        team2.addPlayer(player2);
        team2.removePlayer(player1);
        assertFalse(team2.getSquad().contains(player1));
        assertTrue(team2.getSquad().contains(player2));
        team2.removePlayer(player2);
        assertTrue(team2.getSquad().isEmpty());
    }

    @Test
    void testFindPlayerWithName() {
        assertNull(team1.findPlayerWithName("Mo Salah"));

        team2.addPlayer(player1);
        team2.addPlayer(player2);

        assertEquals(team2.findPlayerWithName("Mo Salah"), player1);
        assertEquals(team2.findPlayerWithName("Paul Pogba"), player2);
        assertNull(team2.findPlayerWithName("Sadio Mane"));
    }

    @Test
    void testAllPlayerNames() {
        assertTrue(team1.allPlayerNames().isEmpty());

        team2.addPlayer(player1);
        team2.addPlayer(player2);

        Collections.addAll(playerNameList,"Mo Salah", "Paul Pogba");
        assertEquals(team2.allPlayerNames(), playerNameList);

        team3.addPlayer(player1);
        team3.addPlayer(player2);
        team3.addPlayer(player3);
        team3.addPlayer(player4);

        Collections.addAll(playerNameList,"Virgil van Dijk","David de Gea");
        assertEquals(team3.allPlayerNames(), playerNameList);
    }

    @Test
    void testCalculateTeamPoints() {
        assertEquals(team1.calculateTeamPoints(),0);

        team2.addPlayer(player1);
        team2.addPlayer(player2);

        teamScore = player1.calculatePoints() + player2.calculatePoints();
        assertEquals(team2.calculateTeamPoints(),teamScore);

        team3.addPlayer(player1);
        team3.addPlayer(player2);
        team3.addPlayer(player3);
        team3.addPlayer(player4);

        teamScore = teamScore + player3.calculatePoints() + player4.calculatePoints();
        assertEquals(team3.calculateTeamPoints(),teamScore);
    }

}
