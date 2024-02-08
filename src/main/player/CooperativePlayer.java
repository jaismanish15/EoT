package src.main.player;

import src.main.Decision;

public class CooperativePlayer extends Player{
    public CooperativePlayer(String name) {
        super(name, Decision.COOPERATE);
    }


    @Override
    public void updateOpponentMove(Decision opponentMove) {

    }
}
