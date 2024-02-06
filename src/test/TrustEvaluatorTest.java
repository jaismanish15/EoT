package src.test;

import org.junit.jupiter.api.Test;
import src.main.*;
import src.main.player.CheatPlayer;
import src.main.player.CooperativePlayer;

import static org.junit.jupiter.api.Assertions.*;

class TrustEvaluatorTest {

    @Test
    void testGameWithTwoCooperatingPlayers() {
        CooperativePlayer player1 = new CooperativePlayer("Player 1");
        CooperativePlayer player2 = new CooperativePlayer("Player 2");
        TrustEvaluator round = new TrustEvaluator();
        assertEquals(2, round.play(player1, player2));
    }

    @Test
    void testGameWithTwoCheatingPlayers() {
        CheatPlayer player1 = new CheatPlayer("Player 1");
        CheatPlayer player2 = new CheatPlayer("Player 2");

        TrustEvaluator game = new TrustEvaluator();
        assertEquals(0, game.play(player1, player2));
    }

    @Test
    void testGameWithOneCheatingAndOneCooperatingPlayer() {
        CooperativePlayer player1 = new CooperativePlayer("Player 1");
        CheatPlayer player2 = new CheatPlayer("Player 2");

        TrustEvaluator game = new TrustEvaluator();
        assertEquals(-1, game.play(player1, player2));
    }

    @Test
    void testGameWithOneCooperatingAndOneCheatingPlayer() {
        CheatPlayer player1 = new CheatPlayer("Player 1");
        CooperativePlayer player2 = new CooperativePlayer("Player 2");

        TrustEvaluator game = new TrustEvaluator();
        assertEquals(3, game.play(player1, player2));
    }

    @Test
    void testGameUpdateCoinForOneCooperatingAndOneCheatingPlayer() {
        CheatPlayer player1 = new CheatPlayer("Player 1");
        CooperativePlayer player2 = new CooperativePlayer("Player 2");

        TrustEvaluator game = new TrustEvaluator();
        assertEquals(3, game.play(player1, player2));
    }


}
