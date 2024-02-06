package src.test;

import org.junit.jupiter.api.Test;
import src.main.*;
import src.main.player.*;

import static org.junit.jupiter.api.Assertions.*;

class TrustTransactorTest {
    @Test
    void testMultipleRoundsWithCheatPlayers_ScoreShouldBeZero() {
        TrustTransactor trustTransactor = new TrustTransactor(new TrustEvaluator());
        CheatPlayer cheatPlayer1 = new CheatPlayer("Player 1");
        CheatPlayer cheatPlayer2 = new CheatPlayer("Player 2");

        assertEquals(0, trustTransactor.playMultipleRounds(cheatPlayer1, cheatPlayer2, 5));
    }

    @Test
    void testMultipleRoundsWithCooperativePlayers_ScoreShouldBe10() {
        TrustTransactor trustTransactor = new TrustTransactor(new TrustEvaluator());
        CooperativePlayer cheatPlayer1 = new CooperativePlayer("Player 1");
        CooperativePlayer cheatPlayer2 = new CooperativePlayer("Player 2");

        assertEquals(10, trustTransactor.playMultipleRounds(cheatPlayer1, cheatPlayer2, 5));
    }

    @Test
    void testMultipleRoundsWithCheatAndCooperativePlayers_ScoreShouldBeNegative5_And_15() {
        TrustTransactor trustTransactor = new TrustTransactor(new TrustEvaluator());
        CooperativePlayer Player1 = new CooperativePlayer("Player 1");
        CheatPlayer Player2 = new CheatPlayer("Player 2");

        assertEquals(-5, trustTransactor.playMultipleRounds(Player1, Player2, 5));
    }

    @Test
    void testMultipleRoundsWithCooperativeAndCooperativePlayers_ScoreShouldBe15_And_Negative5() {
        TrustTransactor trustTransactor = new TrustTransactor(new TrustEvaluator());
        CheatPlayer Player1 = new CheatPlayer("Player 1");
        CooperativePlayer Player2 = new CooperativePlayer("Player 2");

        assertEquals(15, trustTransactor.playMultipleRounds(Player1, Player2, 5));
    }

    @Test
    void testCopyCatPlayerWithCheatPlayer() {
        TrustTransactor trustGame = new TrustTransactor(new TrustEvaluator());
        CopyCatPlayer copyCatPlayer = new CopyCatPlayer("CopyCatPlayer");
        CheatPlayer cheatPlayer = new CheatPlayer("CheatPlayer");

        assertEquals(Decision.CHEAT, copyCatPlayer.makeMove());

        int result = trustGame.playMultipleRounds(copyCatPlayer, cheatPlayer, 4);

        assertEquals(Decision.CHEAT, copyCatPlayer.makeMove());
        assertEquals(Decision.CHEAT, copyCatPlayer.makeMove());
        assertEquals(Decision.CHEAT, copyCatPlayer.makeMove());
        assertEquals(Decision.CHEAT, copyCatPlayer.makeMove());

        assertEquals(0, result);
    }

    @Test
    void testCopyCatPlayerWithCooperativePlayer() {
        TrustTransactor trustGame = new TrustTransactor(new TrustEvaluator());
        CopyCatPlayer copyCatPlayer = new CopyCatPlayer("CopyCatPlayer");
        CooperativePlayer cooperativePlayer = new CooperativePlayer("CooperativePlayer");

        assertEquals(Decision.CHEAT, copyCatPlayer.makeMove());

        int result = trustGame.playMultipleRounds(copyCatPlayer, cooperativePlayer, 4);

        assertEquals(Decision.COOPERATE, copyCatPlayer.makeMove());
        assertEquals(Decision.COOPERATE, copyCatPlayer.makeMove());
        assertEquals(Decision.COOPERATE, copyCatPlayer.makeMove());
        assertEquals(Decision.COOPERATE, copyCatPlayer.makeMove());

        assertEquals(8, result);
    }

    @Test
    void testCopyKittenPlayerWithCheatPlayer() {
        TrustTransactor trustGame = new TrustTransactor(new TrustEvaluator());
        CopyKittenPlayer copyKittenPlayer = new CopyKittenPlayer("CopyKittenPlayer");
        CheatPlayer cheatPlayer = new CheatPlayer("Cheat Player");

        assertEquals(Decision.COOPERATE, copyKittenPlayer.makeMove());

        trustGame.playMultipleRounds(copyKittenPlayer, cheatPlayer, 4);

        assertEquals(Decision.CHEAT, copyKittenPlayer.makeMove());
        assertEquals(Decision.CHEAT, copyKittenPlayer.makeMove());
        assertEquals(Decision.CHEAT, copyKittenPlayer.makeMove());
        assertEquals(Decision.CHEAT, copyKittenPlayer.makeMove());
    }
    @Test
    void testCopyKittenPlayerWithCooperativePlayer() {
        TrustTransactor trustGame = new TrustTransactor(new TrustEvaluator());
        CopyKittenPlayer copyKittenPlayer = new CopyKittenPlayer("CopyKittenPlayer");
        CooperativePlayer cooperativePlayer = new CooperativePlayer("CooperativePlayer");

        assertEquals(Decision.COOPERATE, copyKittenPlayer.makeMove());

        int result = trustGame.playMultipleRounds(copyKittenPlayer, cooperativePlayer, 4);

        assertEquals(Decision.COOPERATE, copyKittenPlayer.makeMove());
        assertEquals(Decision.COOPERATE, copyKittenPlayer.makeMove());
        assertEquals(Decision.COOPERATE, copyKittenPlayer.makeMove());
        assertEquals(Decision.COOPERATE, copyKittenPlayer.makeMove());

        assertEquals(8, result);
    }

    @Test
    void testGrudgePlayerWithCheatPlayer() {
        TrustTransactor trustGame = new TrustTransactor(new TrustEvaluator());
        GrudgePlayer grudgePlayer = new GrudgePlayer("GrudgePlayer");
        CheatPlayer cheatPlayer = new CheatPlayer("Cheat Player");

        assertEquals(Decision.COOPERATE, grudgePlayer.makeMove());

        trustGame.playMultipleRounds(cheatPlayer, grudgePlayer, 4);

        assertEquals(Decision.CHEAT, grudgePlayer.makeMove());
        assertEquals(Decision.CHEAT, grudgePlayer.makeMove());
        assertEquals(Decision.CHEAT, grudgePlayer.makeMove());
        assertEquals(Decision.CHEAT, grudgePlayer.makeMove());
    }
    @Test
    void testGrudgePlayerWithCooperativePlayer() {
        TrustTransactor trustGame = new TrustTransactor(new TrustEvaluator());
        GrudgePlayer grudgePlayer = new GrudgePlayer("GrudgePlayer");
        CooperativePlayer cooperativePlayer = new CooperativePlayer("CooperativePlayer");

        assertEquals(Decision.COOPERATE, grudgePlayer.makeMove());

        int result = trustGame.playMultipleRounds(grudgePlayer, cooperativePlayer, 5);

        assertEquals(Decision.COOPERATE, grudgePlayer.makeMove());
        assertEquals(Decision.COOPERATE, grudgePlayer.makeMove());
        assertEquals(Decision.COOPERATE, grudgePlayer.makeMove());
        assertEquals(Decision.COOPERATE, grudgePlayer.makeMove());

        assertEquals(10, result);
    }

}