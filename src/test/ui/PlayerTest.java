package ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player player1;
    Player player2;
    Player player3;
    Player player4;

    @BeforeEach
    void runBefore() {
        player1 = new Player("Mo Salah", "forward",2,2);
        player2 = new Player("Paul Pogba","midfielder",1,1);
        player3 = new Player("Virgil van Dijk","defender",1,0);
        player4 = new Player("David de Gea","goalkeeper",0,0);
    }

    @Test
    void testGetPlayerName() {
        assertEquals("Mo Salah",player1.getPlayerName());
        assertEquals("Paul Pogba",player2.getPlayerName());
        assertEquals("Virgil van Dijk",player3.getPlayerName());
        assertEquals("David de Gea",player4.getPlayerName());
    }

    @Test
    void testGetPosition() {
        assertEquals("forward", player1.getPosition());
        assertEquals("midfielder", player2.getPosition());
        assertEquals("defender", player3.getPosition());
        assertEquals("goalkeeper", player4.getPosition());
    }

    @Test
    void testGetGoals() {
        assertEquals(2,player1.getGoals());
        assertEquals(1,player2.getGoals());
        assertEquals(1,player3.getGoals());
        assertEquals(0,player4.getGoals());
    }

    @Test
    void testGetAssists() {
        assertEquals(2,player1.getAssists());
        assertEquals(1,player2.getAssists());
        assertEquals(0,player3.getAssists());
        assertEquals(0,player4.getAssists());
    }

    @Test
    void testCalculatePoints() {
        assertEquals((2*4)+(2*3),player1.calculatePoints());
        assertEquals(5+3,player2.calculatePoints());
        assertEquals(6,player3.calculatePoints());
        assertEquals(0,player4.calculatePoints());
    }


}
