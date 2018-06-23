import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlayerTest {


    @Mock
    private PlayerType playerType;

    @Test
    public void shouldReadInputFromConsoleAndReturnInput() {
        when(playerType.readInput()).thenReturn(GameActions.CHEAT.toString());
        assertEquals(GameActions.CHEAT,new Player(playerType).play());
    }
}