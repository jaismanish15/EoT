package src.main;

import src.main.player.CopyCatPlayer;
import src.main.player.Player;

public class TrustTransactor {
    private final TrustEvaluator trustEvaluator;

    public TrustTransactor(TrustEvaluator trustEvaluator) {
        this.trustEvaluator = trustEvaluator;
    }

    public int playMultipleRounds(Player player1, Player player2, int numRounds) {
        int coins = 0;
        for (int round = 0; round < numRounds; round++) {
            coins += playRound(player1, player2);
        }
        return coins;
    }

    private int playRound(Player player1, Player player2) {
        player1.updateOpponentMove(player2.makeMove());
        player2.updateOpponentMove(player1.makeMove());
        return trustEvaluator.play(player1, player2);
    }
}
