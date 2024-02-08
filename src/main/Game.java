package src.main;

import src.main.player.Player;

public class Game {
    private final Player player1;
    private final Player player2;
    private final int numRounds;

    public Game(Player player1, Player player2, int numRounds) {
        this.player1 = player1;
        this.player2 = player2;
        this.numRounds = numRounds;
    }

    public int play() {
        int coins = 0;
        for (int round = 0; round < numRounds; round++) {
            coins += new TrustExchange(player1, player2).outcome;
        }
        return coins;
    }


}
