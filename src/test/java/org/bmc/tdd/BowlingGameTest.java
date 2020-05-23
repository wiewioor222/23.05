package org.bmc.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class BowlingGameTest {

    BowlingGame theGame;

    @BeforeEach
    public void init() {
        theGame = BowlingGame.newGame();
    }

    @Test
    public void shouldScoreOneWhenRolledOne() {
        theGame.nextRound().roll(1);

        assertEquals(1, theGame.getScore());
    }

    @Test
    public void shouldScoreTwoWhenRolledTwice() {
        theGame.nextRound().roll(1).roll(1);

        assertEquals(2, theGame.getScore());
    }

    @Test
    public void shouldScoreThirdWhenRolledThird(){
        theGame.nextRound().roll(3).roll(4);
        theGame.nextRound().roll(3);

        assertEquals(10,theGame.getScore());
    }

    @Test
    public void shouldScoreSpareWhenRolledThird(){
        theGame.nextRound().roll(3).roll(7);
        theGame.nextRound().roll(3).roll(0);

        assertEquals(16,theGame.getScore());
    }

    @Test
    public void shouldScore25WhenRolledThirdRound(){
        theGame.nextRound().roll(3).roll(7);
        theGame.nextRound().roll(3).roll(0);
        theGame.nextRound().roll(3).roll(6);

        assertEquals(25,theGame.getScore());
    }

    @Test
    public void shouldScore25WhenRolledFiveRound(){
        theGame.nextRound().roll(3).roll(7);
        theGame.nextRound().roll(3).roll(0);
        theGame.nextRound().roll(3).roll(6);
        theGame.nextRound().roll(3).roll(7);
        theGame.nextRound().roll(3).roll(0);

        assertEquals(41,theGame.getScore());
    }

    @Test
    public void shouldScore14WhenRolledThirdRound(){
        theGame.nextRound().roll(10).roll(1);
        theGame.nextRound().roll(1);

        assertEquals(14,theGame.getScore());
    }

    @Test
    public void shouldScore35WhenRolledFourRound() {
        theGame.nextRound().roll(10).roll(10);
        theGame.nextRound().roll(1).roll(1);

        assertEquals(35, theGame.getScore());
    }

    @Test()
    public void shouldScore300WhenAllStrike() {
        theGame.nextRound().roll(10).roll(10);
        theGame.nextRound().roll(10).roll(10);
        theGame.nextRound().roll(10).roll(10);
        theGame.nextRound().roll(10).roll(10);
        theGame.nextRound().roll(10).roll(10);
        theGame.nextRound().roll(10).roll(10);
        theGame.nextRound().roll(10).roll(10);
        theGame.nextRound().roll(10).roll(10);
        theGame.nextRound().roll(10).roll(10);
        theGame.nextRound().roll(10).roll(10);
        theGame.nextRound().roll(10);

        assertEquals(300, theGame.getScore());
    }

    @Test
    public void shouldThrowExceptionWhenMoreThan10Pins() {
        assertThrows(TooManyPinsException.class , () -> theGame.nextRound().roll(11));
    }

    @Test
    public void shouldThrowExceptionWhenLowerThan0Pins() {
        assertThrows(LowerThanZeroPinsException.class , () -> theGame.nextRound().roll(-1));
    }

    @Test
    public void shouldThrowExceptionWhenTooManyRounds() {
        theGame.nextRound().roll(10).roll(10);
        theGame.nextRound().roll(10).roll(10);
        theGame.nextRound().roll(10).roll(10);
        theGame.nextRound().roll(10).roll(10);
        theGame.nextRound().roll(10).roll(10);
        theGame.nextRound().roll(10).roll(10);
        theGame.nextRound().roll(10).roll(10);
        theGame.nextRound().roll(10).roll(10);
        theGame.nextRound().roll(10).roll(10);
        theGame.nextRound().roll(10).roll(9);

//        assertThrows(TooManyRoundsException.class , () -> theGame.nextRound().roll(10));
    }
}
