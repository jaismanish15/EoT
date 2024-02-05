import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrustGameTest {

    @Test
    void bothCooperate() {
        TrustGame game = new TrustGame();
        assertEquals(2, game.play(true, true));
    }

    @Test
    void bothCheat() {
        TrustGame game = new TrustGame();
        assertEquals(0, game.play(false, false));
    }

    @Test
    void oneCheatsAndOtherCooperates() {
        TrustGame game = new TrustGame();
        assertEquals(-1, game.play(true, false));
        assertEquals(3, game.play(false, true));
    }

}
