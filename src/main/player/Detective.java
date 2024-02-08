package src.main.player;

import src.main.Decision;

public class Detective extends Player {
    private boolean hasCheatedBack;
    private boolean hasAnalyzedOpponent;

    public Detective(String name) {
        super(name, Decision.COOPERATE);
        this.hasCheatedBack = false;
        this.hasAnalyzedOpponent = false;
    }

    @Override
    public Decision makeMove() {
        if (!hasAnalyzedOpponent) {
            hasAnalyzedOpponent = true;
            return Decision.COOPERATE;
        }

        if (hasCheatedBack) {
            return super.makeMove();
        } else {
            return Decision.CHEAT;
        }
    }

    @Override
    public void updateOpponentMove(Decision opponentMove) {
        if (opponentMove == Decision.CHEAT) {
            hasCheatedBack = true;
        }
        super.updateOpponentMove(opponentMove);
    }
}
