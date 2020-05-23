package org.bmc.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BowlingGameTest {

    BowlingGame theGame = new BowlingGame();

    //10 round
//    2 roll


    //end calculate score
//    10 strike
//    5+5 Spare

    @Test
    public void shouldScoreOneWhenRolledOne() {
        theGame.roll(1);
        assertEquals(1, theGame.getScore());
    }

    @Test
    public void shouldScoreTwoWhenRolledTwice() {
        theGame.roll(1);
        theGame.roll(1);
        assertEquals(2, theGame.getScore());
    }
    @Test
    public void shouldScoreThirdWhenRolledThird(){
        theGame.roll(3);
        theGame.roll(4);
        theGame.roll(3);
        assertEquals(10,theGame.getScore());
    }

    @Test
    public void shouldScoreSpareWhenRolledThird(){
        theGame.roll(3);
        theGame.roll(7);
        theGame.roll(3);
        assertEquals(16,theGame.getScore());
    }

}
