package src.main.player;

import src.main.Decision;

public class CheatPlayer extends Player {
    public CheatPlayer(String name) {
        super(name, Decision.CHEAT);
    }

    @Override
    public void updateOpponentMove(Decision opponentMove) {

    }
}

