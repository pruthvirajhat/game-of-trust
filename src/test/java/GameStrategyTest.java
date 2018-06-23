import org.junit.Test;

import static org.junit.Assert.*;

public class GameStrategyTest {

    @Test
    public void ShouldReturn3Minus1ForInput10() {
        assertEquals(new Score(3, -1).toString(),
                new GameStrategy().calculateScore(
                        GameActions.CHEAT,
                        GameActions.COOPRATE).toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException() {
        new GameStrategy().calculateScore(null, GameActions.COOPRATE);
    }
}