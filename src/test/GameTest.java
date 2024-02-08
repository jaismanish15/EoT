package src.test;

import org.junit.jupiter.api.Test;
import src.main.*;
import src.main.player.*;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void testMultipleRoundsWithCheatPlayers_ScoreShouldBeZero() {

        CheatPlayer cheatPlayer1 = new CheatPlayer("Player 1");
        CheatPlayer cheatPlayer2 = new CheatPlayer("Player 2");
        Game game = new Game(cheatPlayer1, cheatPlayer2, 5);
        assertEquals(0, game.play());
    }

    @Test
    void testMultipleRoundsWithCooperativePlayers_ScoreShouldBe10() {

        CooperativePlayer cheatPlayer1 = new CooperativePlayer("Player 1");
        CooperativePlayer cheatPlayer2 = new CooperativePlayer("Player 2");
        Game game = new Game(cheatPlayer1,cheatPlayer2,5);
        assertEquals(10, game.play());
    }

    @Test
    void testMultipleRoundsWithCheatAndCooperativePlayers_ScoreShouldBeNegative5_And_15() {
        CooperativePlayer Player1 = new CooperativePlayer("Player 1");
        CheatPlayer Player2 = new CheatPlayer("Player 2");
        Game game = new Game(Player1, Player2, 5);
        assertEquals(-5, game.play());
    }

    @Test
    void testMultipleRoundsWithCooperativeAndCooperativePlayers_ScoreShouldBe15_And_Negative5() {
        CheatPlayer player1 = new CheatPlayer("Player 1");
        CooperativePlayer player2 = new CooperativePlayer("Player 2");
        Game game = new Game(player1, player2, 5);
        assertEquals(15, game.play());
    }

    @Test
    void testCopyCatPlayerWithCheatPlayer() {
        CopyCatPlayer copyCatPlayer = new CopyCatPlayer("CopyCatPlayer");
        CheatPlayer cheatPlayer = new CheatPlayer("CheatPlayer");
        Game trustGame = new Game(copyCatPlayer, cheatPlayer, 4);
        int actual = trustGame.play();
        assertEquals(Decision.CHEAT, copyCatPlayer.makeMove());

        assertEquals(Decision.CHEAT, copyCatPlayer.makeMove());
        assertEquals(Decision.CHEAT, copyCatPlayer.makeMove());
        assertEquals(Decision.CHEAT, copyCatPlayer.makeMove());
        assertEquals(Decision.CHEAT, copyCatPlayer.makeMove());

        assertEquals(0, actual);
    }

    @Test
    void testCopyCatPlayerWithCooperativePlayer() {
        CopyCatPlayer copyCatPlayer = new CopyCatPlayer("CopyCatPlayer");
        CooperativePlayer cooperativePlayer = new CooperativePlayer("CooperativePlayer");
        Game trustGame = new Game(copyCatPlayer,cooperativePlayer, 4);
        assertEquals(Decision.CHEAT, copyCatPlayer.makeMove());

        int actual = trustGame.play();

        assertEquals(Decision.COOPERATE, copyCatPlayer.makeMove());
        assertEquals(Decision.COOPERATE, copyCatPlayer.makeMove());
        assertEquals(Decision.COOPERATE, copyCatPlayer.makeMove());
        assertEquals(Decision.COOPERATE, copyCatPlayer.makeMove());
        assertEquals(9, actual);

    }

    @Test
    void testCopyKittenPlayerWithCheatPlayer() {
        CopyKittenPlayer copyKittenPlayer = new CopyKittenPlayer("CopyKittenPlayer");
        CheatPlayer cheatPlayer = new CheatPlayer("Cheat Player");
        Game trustGame = new Game(cheatPlayer, copyKittenPlayer, 4);
        assertEquals(Decision.COOPERATE, copyKittenPlayer.makeMove());

        trustGame.play();

        assertEquals(Decision.CHEAT, copyKittenPlayer.makeMove());
        assertEquals(Decision.CHEAT, copyKittenPlayer.makeMove());
        assertEquals(Decision.CHEAT, copyKittenPlayer.makeMove());
        assertEquals(Decision.CHEAT, copyKittenPlayer.makeMove());
    }

    @Test
    void testCopyKittenPlayerWithCooperativePlayer() {
        CopyKittenPlayer copyKittenPlayer = new CopyKittenPlayer("CopyKittenPlayer");
        CooperativePlayer cooperativePlayer = new CooperativePlayer("CooperativePlayer");
        Game trustGame = new Game(copyKittenPlayer, cooperativePlayer, 4);
        assertEquals(Decision.COOPERATE, copyKittenPlayer.makeMove());

        int result = trustGame.play();

        assertEquals(Decision.COOPERATE, copyKittenPlayer.makeMove());
        assertEquals(Decision.COOPERATE, copyKittenPlayer.makeMove());
        assertEquals(Decision.COOPERATE, copyKittenPlayer.makeMove());
        assertEquals(Decision.COOPERATE, copyKittenPlayer.makeMove());

        assertEquals(8, result);
    }

    @Test
    void testGrudgePlayerWithCheatPlayer() {
        GrudgePlayer grudgePlayer = new GrudgePlayer("GrudgePlayer");
        CheatPlayer cheatPlayer = new CheatPlayer("Cheat Player");
        Game trustGame = new Game(cheatPlayer, grudgePlayer, 4);
        assertEquals(Decision.COOPERATE, grudgePlayer.makeMove());

        trustGame.play();

        assertEquals(Decision.CHEAT, grudgePlayer.makeMove());
        assertEquals(Decision.CHEAT, grudgePlayer.makeMove());
        assertEquals(Decision.CHEAT, grudgePlayer.makeMove());
        assertEquals(Decision.CHEAT, grudgePlayer.makeMove());
    }

    @Test
    void testGrudgePlayerWithCooperativePlayer() {
        Player grudgePlayer = new GrudgePlayer("GrudgePlayer");
        CooperativePlayer cooperativePlayer = new CooperativePlayer("CooperativePlayer");
        Game trustGame = new Game(grudgePlayer, cooperativePlayer, 5);
        assertEquals(Decision.COOPERATE, grudgePlayer.makeMove());

        int result = trustGame.play();

        assertEquals(Decision.COOPERATE, grudgePlayer.makeMove());
        assertEquals(Decision.COOPERATE, grudgePlayer.makeMove());
        assertEquals(Decision.COOPERATE, grudgePlayer.makeMove());
        assertEquals(Decision.COOPERATE, grudgePlayer.makeMove());

        assertEquals(10, result);
    }


}