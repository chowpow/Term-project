package ui;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {
    Team team1;
    Team team2;
    Team team3;

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
        player1 = new Forward("Mo Salah", "forward", 2, 2);
        player2 = new Midfielder("Paul Pogba", "midfielder", 1, 1);
        player3 = new Defender("Virgil van Dijk", "defender", 1, 0);
        player4 = new Goalkeeper("David de Gea", "goalkeeper", 0, 0);

        team1 = new Team();
        team2 = new Team();
        team3 = new Team();

        playerList = new ArrayList<Player>();
        playerList1 = new ArrayList<Player>();
        playerNameList = new ArrayList<String>();

        teamScore = 0;
    }

    @Test
    void testGetSquad() throws FantasyTeamFullException {
        Collections.addAll(playerList, player1, player2);
        Collections.addAll(playerList1, player1, player2, player3, player4);
        team2.addPlayer(player1);
        team2.addPlayer(player2);

        assertTrue(team1.getSquad().isEmpty());
        assertEquals(team2.getSquad(), playerList);

        team3.addPlayer(player1);
        team3.addPlayer(player2);
        team3.addPlayer(player3);
        team3.addPlayer(player4);

        assertEquals(team3.getSquad(), playerList1);
    }

    @Test
    void testAddPlayer() throws FantasyTeamFullException {
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
    void testRemovePlayer() throws FantasyTeamFullException {
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
    void testFindPlayerWithName() throws FantasyTeamFullException {
        assertNull(team1.findPlayerWithName("Mo Salah"));

        team2.addPlayer(player1);
        team2.addPlayer(player2);

        assertEquals(team2.findPlayerWithName("Mo Salah"), player1);
        assertEquals(team2.findPlayerWithName("Paul Pogba"), player2);
        assertNull(team2.findPlayerWithName("Sadio Mane"));
    }

    @Test
    void testAllPlayerNames() throws FantasyTeamFullException {
        assertTrue(team1.allPlayerNames().isEmpty());

        team2.addPlayer(player1);
        team2.addPlayer(player2);

        Collections.addAll(playerNameList, "Mo Salah", "Paul Pogba");
        assertEquals(team2.allPlayerNames(), playerNameList);

        team3.addPlayer(player1);
        team3.addPlayer(player2);
        team3.addPlayer(player3);
        team3.addPlayer(player4);

        Collections.addAll(playerNameList, "Virgil van Dijk", "David de Gea");
        assertEquals(team3.allPlayerNames(), playerNameList);
    }

    @Test
    void testCalculateTeamPoints() throws FantasyTeamFullException {
        assertEquals(team1.calculateTeamPoints(), 0);

        team2.addPlayer(player1);
        team2.addPlayer(player2);

        teamScore = player1.calculatePoints() + player2.calculatePoints();
        assertEquals(team2.calculateTeamPoints(), teamScore);

        team3.addPlayer(player1);
        team3.addPlayer(player2);
        team3.addPlayer(player3);
        team3.addPlayer(player4);

        teamScore = teamScore + player3.calculatePoints() + player4.calculatePoints();
        assertEquals(team3.calculateTeamPoints(), teamScore);
    }

    @Test
    void testTooManyPlayers() throws FantasyTeamFullException {
        for (int i = 0; i < 11; i++) {
            team1.addPlayer(player1);
        }
        try {
            team1.addPlayer(player1);
            fail("Failed test!");
        } catch (FantasyTeamFullException e) {
        }
    }

    @Test
    void testTeamNotFull() throws FantasyTeamFullException {
        for (int i = 0; i < 10; i++) {
            team1.addPlayer(player1);
        }
        try {
            team1.addPlayer(player1);
        } catch (FantasyTeamFullException e) {
            fail("Test Failed!");
        }
    }
}



