package src.test;

import org.junit.jupiter.api.Test;
import src.main.Decision;
import src.main.player.CopyCatPlayer;

import static org.junit.jupiter.api.Assertions.*;

class CopyCatPlayerTest {
    @Test
    void testCopyCatPlayerBehavior() {
        CopyCatPlayer copyCatPlayer = new CopyCatPlayer("CopyCatPlayer");

        assertEquals(Decision.CHEAT, copyCatPlayer.makeMove());

        copyCatPlayer.updateOpponentMove(Decision.COOPERATE);
        assertEquals(Decision.COOPERATE, copyCatPlayer.makeMove());

        copyCatPlayer.updateOpponentMove(Decision.CHEAT);
        assertEquals(Decision.CHEAT, copyCatPlayer.makeMove());

        copyCatPlayer.updateOpponentMove(Decision.CHEAT);
        assertEquals(Decision.CHEAT, copyCatPlayer.makeMove());
    }

}