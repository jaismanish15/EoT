package src.main;


import src.main.player.Player;

import java.util.List;

public class Tournament {
    private final List<Player> players;

    public Tournament(List<Player> players) {
        this.players = players;
    }

//    public void play() {
//        for (int i = 0; i < players.size(); i++) {
//            for (int j = i + 1; j < players.size(); j++) {
//                Player player1 = players.get(i);
//                Player player2 = players.get(j);
//                Game transactor = new Game(new TrustExchange());
//                int score = transactor.playMultipleRounds(player1, player2, 5); // Adjust rounds as needed
//            }
//        }
//
//        eliminateWorstPlayers();
//        reproduceBestPlayers();
//    }


}
