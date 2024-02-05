public class TrustGame {
    public int play(boolean player1Cooperates, boolean player2Cooperates) {
        if (player1Cooperates && player2Cooperates) {
            return 2;
        } else if (!player1Cooperates && !player2Cooperates) {
            return 0;
        } else {
            return player1Cooperates ? -1 : 3;
        }
    }
}
