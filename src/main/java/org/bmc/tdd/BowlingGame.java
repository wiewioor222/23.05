package org.bmc.tdd;

public class BowlingGame {

    private GameManager gameManager = new GameManager();

    public int getScore() {
        return gameManager.getScore();
    }

    public Round nextGame(){
        return gameManager.nextGame();
    }
}
