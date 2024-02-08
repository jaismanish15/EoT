package src.main.player;

import src.main.Decision;

import java.util.ArrayList;
import java.util.List;

public class CopyKittenPlayer extends Player {
    private Decision opponentMove;

    public CopyKittenPlayer(String name) {
        super(name, Decision.COOPERATE);
        this.opponentMove = null;
    }

    @Override
    public void updateOpponentMove(Decision opponentMove) {
        this.opponentMove = opponentMove;
    }

    @Override
    public Decision makeMove() {
        if (opponentMove!=null) {
            return opponentMove;
        }
        return super.makeMove();
    }
}
