package src.main.player;

import src.main.Decision;


public class GrudgePlayer extends Player {
    private boolean hasBeenCheated;

    public GrudgePlayer(String name) {
        super(name, Decision.COOPERATE);
        this.hasBeenCheated = false;
    }

    @Override
    public void updateOpponentMove(Decision opponentMove) {
        if (opponentMove == Decision.CHEAT) {
            hasBeenCheated = true;
        }
    }

    @Override
    public Decision makeMove() {
        if (hasBeenCheated) {
            return Decision.CHEAT;
        }
        return Decision.COOPERATE;
    }
}
