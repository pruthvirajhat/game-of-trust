import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    @Mock
    private PlayerType consoleReader;
    private Player player1, player2;
    private GameStrategy gameStrategy;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        player1 = new Player(consoleReader);
        player2 = new Player(consoleReader);
        gameStrategy = new GameStrategy();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldReturnScore3Minus1ForInputCheatCooperate() {
        when(consoleReader.readInput()).thenReturn(GameActions.CHEAT.toString()).thenReturn(GameActions.COOPRATE.toString())
        .thenReturn(GameActions.CHEAT.toString()).thenReturn(GameActions.COOPRATE.toString())
        .thenReturn(GameActions.COOPRATE.toString()).thenReturn(GameActions.COOPRATE.toString());
        new Game(player1, player2, gameStrategy, 3).start();
        assertEquals(8, player1.getPoints());
        assertEquals(0, player2.getPoints());
    }

    @Test
    public void verifyTotalNumberOfMoves() {
        when(consoleReader.readInput()).thenReturn(GameActions.CHEAT.toString()).thenReturn(GameActions.COOPRATE.toString());
        new Game(player1, player2, gameStrategy, 5).start();
        verify(consoleReader, times(10)).readInput();
    }

    @Test
    public void verifyConsoleScore(){
        when(consoleReader.readInput()).thenReturn(GameActions.CHEAT.toString()).thenReturn(GameActions.COOPRATE.toString());
        new Game(player1, player2, gameStrategy, 1).start();
        assertEquals("3, -1", outContent.toString());
    }

    @Test
    public void shouldReturn3Minus1ForInputCheatPlayerCooperatePlayerWith1Move()
    {
        Player cheatPlayer = new Player(PlayerType.CHEAT_PLAYER);
        Player cooperatePlayer = new Player(PlayerType.COOPERATE_PLAYER);
        new Game(cheatPlayer, cooperatePlayer, gameStrategy, 1).start();
        assertEquals(3, cheatPlayer.getPoints());
        assertEquals(-1, cooperatePlayer.getPoints());
    }

    @Test
    public void shouldReturn3Minus1ForInputCheatPlayerCooperatePlayerWith10Moves()
    {
        Player cheatPlayer = new Player(PlayerType.CHEAT_PLAYER);
        Player cooperatePlayer = new Player(PlayerType.COOPERATE_PLAYER);
        new Game(cheatPlayer, cooperatePlayer, gameStrategy, 10).start();
        assertEquals(30, cheatPlayer.getPoints());
        assertEquals(-10, cooperatePlayer.getPoints());
    }
}