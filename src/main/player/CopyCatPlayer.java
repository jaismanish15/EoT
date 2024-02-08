package src.main.player;

import src.main.Decision;

import java.util.ArrayList;
import java.util.List;

public class CopyCatPlayer extends Player {
    private Decision opponentMove;

    public CopyCatPlayer(String name) {
        super(name, Decision.CHEAT);
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

