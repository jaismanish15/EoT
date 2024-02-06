package src.test;

import org.junit.jupiter.api.Test;
import src.main.Decision;
import src.main.player.CopyKittenPlayer;

import static org.junit.jupiter.api.Assertions.*;

class CopyKittenPlayerTest {

    @Test
    void testCopyKittenPlayerBehavior() {
        CopyKittenPlayer copyKittenPlayer = new CopyKittenPlayer("CopyKittenPlayer");

        assertEquals(Decision.COOPERATE, copyKittenPlayer.makeMove());

        copyKittenPlayer.updateOpponentMove(Decision.CHEAT);
        assertEquals(Decision.CHEAT, copyKittenPlayer.makeMove());

        copyKittenPlayer.updateOpponentMove(Decision.COOPERATE);
        assertEquals(Decision.COOPERATE, copyKittenPlayer.makeMove());

        copyKittenPlayer.updateOpponentMove(Decision.CHEAT);
        assertEquals(Decision.CHEAT, copyKittenPlayer.makeMove());
    }

}