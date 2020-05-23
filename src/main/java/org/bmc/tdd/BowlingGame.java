package org.bmc.tdd;

import java.util.Arrays;
import java.util.Objects;

public class BowlingGame {

    private Roll[] rolls = new Roll[20];

    public int getScore() {
        return Arrays.stream(rolls).filter(Objects::nonNull).mapToInt(Roll::getPins).sum();
    }

    public void roll(int pins){
        rolls[0] = new Roll(pins);
    }
}
