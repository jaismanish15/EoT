package src.main.player;

import src.main.Decision;

public abstract class Player {
    private String name;
    private Decision move;
    private int coins;

    public Player(String name, Decision move) {
        this.name = name;
        this.move = move;
    }


    public abstract void updateOpponentMove(Decision opponentMove);

    public Decision makeMove() {
        return move;
    }


}
