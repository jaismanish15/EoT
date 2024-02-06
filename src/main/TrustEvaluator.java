package src.main;

import src.main.player.Player;

public class TrustEvaluator {

    public int play(Player player1, Player player2) {
        Decision player1Move = player1.makeMove();
        Decision player2Move = player2.makeMove();

        return evaluateMoves(player1Move, player2Move);
    }

    private int evaluateMoves(Decision player1Move, Decision player2Move) {
        if (player1Move == Decision.COOPERATE && player2Move == Decision.COOPERATE) {
            return 2;
        } else if (player1Move == Decision.CHEAT && player2Move == Decision.CHEAT) {
            return 0;
        } else {
            return player1Move == Decision.COOPERATE ? -1 : 3;
        }
    }
}
