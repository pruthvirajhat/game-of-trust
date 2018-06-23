import java.util.Observable;
import java.util.Observer;

public class CopyCatPlayer implements Observer, PlayerType {

    private GameActions lastMove = GameActions.COOPRATE;

    @Override
    public String readInput() {

        return lastMove.toString();
    }

    @Override
    public void update(Observable o, Object arg) {
        lastMove = (GameActions) arg;
    }
}
