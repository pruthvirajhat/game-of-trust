public interface PlayerType {

    String readInput();


    PlayerType CHEAT_PLAYER = GameActions.CHEAT::toString;
    PlayerType COOPERATE_PLAYER = GameActions.COOPRATE::toString;

}
