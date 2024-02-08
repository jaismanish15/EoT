package src.main.player;

import src.main.Decision;

public abstract class Player {
    private final String name;
    protected Decision move;

    public Player(String name, Decision move) {
        this.name = name;
        this.move = move;
    }

    public void updateOpponentMove(Decision opponentMove) {
    }

    public Decision makeMove() {
        return move;
    }
}
