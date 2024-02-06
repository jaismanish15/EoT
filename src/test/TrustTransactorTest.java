package src.test;

import org.junit.jupiter.api.Test;
import src.main.*;
import src.main.player.CheatPlayer;
import src.main.player.CooperativePlayer;
import src.main.player.CopyCatPlayer;

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
    void testCopyCatPlayerBehavior() {
        TrustTransactor trustGame = new TrustTransactor(new TrustEvaluator());
        CopyCatPlayer copyCatPlayer = new CopyCatPlayer("CopyCatPlayer");
        CooperativePlayer cooperatePlayer = new CooperativePlayer("Player");


        assertEquals(Decision.CHEAT, copyCatPlayer.makeMove());

        trustGame.playMultipleRounds(cooperatePlayer, copyCatPlayer, 5);

        assertEquals(Decision.COOPERATE, copyCatPlayer.makeMove());
        assertEquals(Decision.COOPERATE, copyCatPlayer.makeMove());
        assertEquals(Decision.COOPERATE, copyCatPlayer.makeMove());
        assertEquals(Decision.COOPERATE, copyCatPlayer.makeMove());
    }



}