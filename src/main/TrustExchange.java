package src.main;

import src.main.player.Player;

public class TrustExchange {
    private final Player player1;
    private final Player player2;
    protected final int outcome;


    public TrustExchange(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.outcome = play();

    }

    public int play() {
        Decision player1Move = player1.makeMove();
        Decision player2Move = player2.makeMove();

        player1.updateOpponentMove(player2Move);
        player2.updateOpponentMove(player1Move);

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
