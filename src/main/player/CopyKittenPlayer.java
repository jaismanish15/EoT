package src.main.player;

import src.main.Decision;

import java.util.ArrayList;
import java.util.List;

public class CopyKittenPlayer extends Player {
    private final List<Decision> opponentMoves;

    public CopyKittenPlayer(String name) {
        super(name, Decision.COOPERATE);
        this.opponentMoves = new ArrayList<>();
    }

    @Override
    public void updateOpponentMove(Decision opponentMove) {
        opponentMoves.add(opponentMove);
    }

    @Override
    public Decision makeMove() {
        if (!opponentMoves.isEmpty()) {
            return opponentMoves.getLast();
        }
        return super.makeMove();
    }
}
