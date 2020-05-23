package org.bmc.tdd;

public class BowlingGame {
    private GameManager gameManager = new GameManager();

    private BowlingGame(){
    }

    public static BowlingGame newGame(){
        return new BowlingGame();
    }

    public int getScore() {
        return gameManager.getScore();
    }

    public Round nextRound(){
        return gameManager.nextGame();
    }
}
