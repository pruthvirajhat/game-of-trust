import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Player extends Observable {

    private int points;
    private PlayerType playerType;
    private List<PlayerType> listOFObervers = new ArrayList<PlayerType>();
    private GameActions lastResponse;

    public Player(PlayerType playerType) {
        this.playerType = playerType;
    }

    public int getPoints() {
        return points;
    }

    public void updatePoints(int points) {
        this.points += points;
    }

    public GameActions play() {
        try {
            lastResponse = GameActions.valueOf(playerType.readInput());
            return lastResponse;
        } catch (Exception ex) {
            return play();
        }
    }
}