import java.util.HashMap;
import java.util.Map;

public class GameStrategy {

    private final static Map<String, Score> scoreMap = new HashMap<String, Score>() {
        {
            put(GameActions.CHEAT + "," + GameActions.COOPRATE, new Score(3, -1));
            put(GameActions.COOPRATE + "," + GameActions.COOPRATE, new Score(2, 2));
            put(GameActions.COOPRATE + "," + GameActions.CHEAT, new Score(-1, 3));
            put(GameActions.CHEAT + "," + GameActions.CHEAT, new Score(0, 0));
        }
    };

    public Score calculateScore(GameActions player1Input, GameActions player2Input) {

        if (null == scoreMap.get(player1Input + "," + player2Input)) {
            throw new IllegalArgumentException();
        }

        return scoreMap.get(player1Input + "," + player2Input);

    }
}
