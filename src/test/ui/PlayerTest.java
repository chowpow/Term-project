package ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player player1 = new Player();
    Player player2 = new Player();
    Player player3 = new Player();
    Player player4 = new Player();

    @BeforeEach
    void runBefore() {
        player1.makePlayer("Mo Salah", "forward",2,2);
        player2.makePlayer("Paul Pogba","midfielder",1,1);
        player3.makePlayer("Virgil van Dijk","defender",1,0);
        player4.makePlayer("David de Gea","goalkeeper",0,0);
    }

    @Test
    void testGetPlayerName() {
        assertEquals("Mo Salah",player1.getPlayerName());
        assertEquals("Paul Pogba",player2.getPlayerName());
        assertEquals("Virgil van Dijk",player3.getPlayerName());
        assertEquals("David de Gea",player4.getPlayerName());
    }

    @Test
    void testCalculatePoints() {
        assertEquals((2*4)+(2*3),player1.calculatePoints());
        assertEquals(5+3,player2.calculatePoints());
        assertEquals(6,player3.calculatePoints());
        assertEquals(0,player4.calculatePoints());
    }


}
