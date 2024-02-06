package src.test;

import org.junit.jupiter.api.Test;
import src.main.Decision;
import src.main.player.GrudgePlayer;

import static org.junit.jupiter.api.Assertions.*;

class GrudgePlayerTest {
    @Test
    void testGrudgePlayerBehavior() {
        GrudgePlayer grudgePlayer = new GrudgePlayer("GrudgePlayer");

        assertEquals(Decision.COOPERATE, grudgePlayer.makeMove());

        assertEquals(Decision.COOPERATE, grudgePlayer.makeMove());

        grudgePlayer.updateOpponentMove(Decision.CHEAT);
        assertEquals(Decision.CHEAT, grudgePlayer.makeMove());

        assertEquals(Decision.CHEAT, grudgePlayer.makeMove());
        assertEquals(Decision.CHEAT, grudgePlayer.makeMove());

        grudgePlayer.updateOpponentMove(Decision.COOPERATE);
        assertEquals(Decision.CHEAT, grudgePlayer.makeMove());
    }

}