public class Game {

    private final Player player1;
    private final Player player2;
    private final GameStrategy gameStrategy;
    private final int noOfTurns;

    public Game(Player player1, Player player2, GameStrategy gameStrategy,int noOfTurns) {

        this.player1 = player1;
        this.player2 = player2;
        this.gameStrategy = gameStrategy;
        this.noOfTurns  = noOfTurns;
    }

    public void start() {
        for(int index = 0; index < noOfTurns; index++){

            Score currentScore = gameStrategy.calculateScore(
                    player1.play(),
                    player2.play());
            player1.updatePoints(currentScore.getPlayer1Score());
            player2.updatePoints(currentScore.getPlayer2Score());
            displayScores();
        }
    }

    public void displayScores(){
        System.out.println(player1.getPoints()+", "+player2.getPoints());
    }
}
