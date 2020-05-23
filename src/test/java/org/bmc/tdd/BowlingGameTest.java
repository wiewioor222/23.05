package org.bmc.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BowlingGameTest {

    BowlingGame theGame = new BowlingGame();

    @Test
    public void shouldScoreOneWhenRolledOne() {
        theGame.nextGame().roll(1);
        assertEquals(1, theGame.getScore());
    }

    @Test
    public void shouldScoreTwoWhenRolledTwice() {
        theGame.nextGame().roll(1).roll(1);

        assertEquals(2, theGame.getScore());
    }
    @Test
    public void shouldScoreThirdWhenRolledThird(){
        theGame.nextGame().roll(3).roll(4);
        theGame.nextGame().roll(3);
        assertEquals(10,theGame.getScore());
    }

    @Test
    public void shouldScoreSpareWhenRolledThird(){
        theGame.nextGame().roll(3).roll(7);
        theGame.nextGame().roll(3).roll(0);
        assertEquals(16,theGame.getScore());
    }

    @Test
    public void shouldScore25WhenRolledThirdRound(){
        theGame.nextGame().roll(3).roll(7);
        theGame.nextGame().roll(3).roll(0);
        theGame.nextGame().roll(3).roll(6);
        assertEquals(25,theGame.getScore());
    }

    @Test
    public void shouldScore25WhenRolledFiveRound(){
        theGame.nextGame().roll(3).roll(7);
        theGame.nextGame().roll(3).roll(0);
        theGame.nextGame().roll(3).roll(6);
        theGame.nextGame().roll(3).roll(7);
        theGame.nextGame().roll(3).roll(0);
        assertEquals(41,theGame.getScore());
    }

    @Test
    public void shouldScore30WhenRolledThirdRound(){
        theGame.nextGame().roll(10).roll(1);
        theGame.nextGame().roll(1);
        assertEquals(14,theGame.getScore());
    }

}
