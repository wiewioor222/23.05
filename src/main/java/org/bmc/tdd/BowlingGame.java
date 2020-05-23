package org.bmc.tdd;

import java.util.Arrays;
import java.util.Objects;

public class BowlingGame {

    private Roll[] rolls = new Roll[20];
    private int index;
    public int getScore() {
        return Arrays.stream(rolls).filter(Objects::nonNull).mapToInt(Roll::getPins).sum();
    }

    public void roll(int pins){

        rolls[index] = new Roll(pins);
        index++;
    }
}
