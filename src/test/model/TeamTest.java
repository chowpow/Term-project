package model;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {
    Team team1;
    Team team2;
    Team team3;

    Player player1;
    Player player2;
    Player player3;
    Player player4;
    Player player5;
    Player player6;
    Player player7;
    Player player8;
    Player player9;
    Player player10;
    Player player11;
    Player player12;

    Set<Player> playerList;
    Set<Player> playerList1;
    Set<String> playerNameList;

    int teamScore;

    @BeforeEach
    void runBefore() {
        player1 = new Forward("Mo Salah", "forward", 2, 2);
        player2 = new Midfielder("Paul Pogba", "midfielder", 1, 1);
        player3 = new Defender("Virgil van Dijk", "defender", 1, 0);
        player4 = new Goalkeeper("David de Gea", "goalkeeper", 0, 0);
        player5 = new Forward("Raheem Sterling", "forward", 0,0);
        player6 = new Midfielder("James Maddison", "midfielder", 1, 1);
        player7 = new Defender("Harry Maguire", "defender", 1, 0);
        player8 = new Forward("Marcus Rashford", "forward", 1, 0);
        player9 = new Forward("Jamie Vardy", "forward", 1, 0);
        player10 = new Midfielder("Christian Eriksen", "midfielder", 1, 0);
        player11 = new Defender("David Luiz", "defender", 1, 0);
        player12 = new Forward("Sergio Aguero","forward",0,0);

        team1 = new Team();
        team2 = new Team();
        team3 = new Team();

        playerList = new HashSet<>();
        playerList1 = new HashSet<>();
        playerNameList = new HashSet<>();

        teamScore = 0;
    }

    @Test
    void testGetSquad() throws FantasyTeamFullException {
        Collections.addAll(playerList, player1, player2);
        Collections.addAll(playerList1, player1, player2, player3, player4);
        team2.addPlayer(player1);
        team2.addPlayer(player2);

        assertTrue(team2.getSquad().equals(playerList));

        team3.addPlayer(player1);
        team3.addPlayer(player2);
        team3.addPlayer(player3);
        team3.addPlayer(player4);

        assertTrue(team3.getSquad().equals(playerList1));
    }

    @Test
    void testGetPlayer() throws FantasyTeamFullException {
        team1.addPlayer(player1);
        team1.addPlayer(player2);
        team1.addPlayer(player3);

        System.out.println(player1 == player2);

        assertEquals(player1, team1.getPlayer("Mo Salah"));
        assertFalse(player2.equals(team1.getPlayer("Mo Salah")));
    }

    @Test
    void testSizeOfSquad() throws FantasyTeamFullException {
        team1.addPlayer(player1);
        team1.addPlayer(player2);
        team1.addPlayer(player3);
        team1.addPlayer(player4);
        assertEquals(4,team1.sizeOfSquad());
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
        team1.removePlayer("Mo Salah");
        assertTrue(team1.getSquad().isEmpty());

        team2.addPlayer(player1);
        team2.addPlayer(player2);
        team2.removePlayer("Mo Salah");
        assertFalse(team2.getSquad().contains(player1));
        assertTrue(team2.getSquad().contains(player2));
        team2.removePlayer("Paul Pogba");
        assertTrue(team2.getSquad().isEmpty());
    }

    @Test
    void testAllPlayerNames() throws FantasyTeamFullException {
        assertTrue(team1.allPlayerNames().isEmpty());

        team2.addPlayer(player1);
        team2.addPlayer(player2);

        Collections.addAll(playerNameList, "Mo Salah", "Paul Pogba");
        assertTrue(team2.allPlayerNames().equals(playerNameList));

        team3.addPlayer(player1);
        team3.addPlayer(player2);
        team3.addPlayer(player3);
        team3.addPlayer(player4);

        Collections.addAll(playerNameList, "Virgil van Dijk", "David de Gea");
        assertTrue(team3.allPlayerNames().equals(playerNameList));
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
        team1.addPlayer(player1);
        team1.addPlayer(player2);
        team1.addPlayer(player3);
        team1.addPlayer(player4);
        team1.addPlayer(player5);
        team1.addPlayer(player6);
        team1.addPlayer(player7);
        team1.addPlayer(player8);
        team1.addPlayer(player9);
        team1.addPlayer(player10);
        team1.addPlayer(player11);

        try {
            team1.addPlayer(player12);
            fail("Failed test!");
        } catch (FantasyTeamFullException e) {
        }
    }

    @Test
    void testTeamNotFull() throws FantasyTeamFullException {
        team1.addPlayer(player1);
        team1.addPlayer(player2);
        team1.addPlayer(player3);
        team1.addPlayer(player4);
        team1.addPlayer(player5);
        team1.addPlayer(player6);
        team1.addPlayer(player7);
        team1.addPlayer(player8);
        team1.addPlayer(player9);
        team1.addPlayer(player10);

        try {
            team1.addPlayer(player11);
        } catch (FantasyTeamFullException e) {
            fail("Test Failed!");
        }
    }
}



