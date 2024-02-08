package src.test;

import org.junit.jupiter.api.Test;
import src.main.*;
import src.main.player.CheatPlayer;
import src.main.player.CooperativePlayer;
import src.main.player.Detective;

import static org.junit.jupiter.api.Assertions.*;

class TrustExchangeTest {

    @Test
    void testGameWithTwoCooperatingPlayers() {
        CooperativePlayer player1 = new CooperativePlayer("Player 1");
        CooperativePlayer player2 = new CooperativePlayer("Player 2");
        TrustExchange round = new TrustExchange(player1,player2);
        assertEquals(2, round.play());
    }

    @Test
    void testGameWithTwoCheatingPlayers() {
        CheatPlayer player1 = new CheatPlayer("Player 1");
        CheatPlayer player2 = new CheatPlayer("Player 2");

        TrustExchange game = new TrustExchange(player1,player2);
        assertEquals(0, game.play());
    }

    @Test
    void testGameWithOneCheatingAndOneCooperatingPlayer() {
        CooperativePlayer player1 = new CooperativePlayer("Player 1");
        CheatPlayer player2 = new CheatPlayer("Player 2");

        TrustExchange game = new TrustExchange(player1, player2);
        assertEquals(-1, game.play());
    }

    @Test
    void testGameWithOneCooperatingAndOneCheatingPlayer() {
        CheatPlayer player1 = new CheatPlayer("Player 1");
        CooperativePlayer player2 = new CooperativePlayer("Player 2");

        TrustExchange game = new TrustExchange(player1, player2);
        assertEquals(3, game.play());
    }

    @Test
    void testGameUpdateCoinForOneCooperatingAndOneCheatingPlayer() {
        CheatPlayer player1 = new CheatPlayer("Player 1");
        CooperativePlayer player2 = new CooperativePlayer("Player 2");

        TrustExchange game = new TrustExchange(player1, player2);
        assertEquals(3, game.play());
    }



}
