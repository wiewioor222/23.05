package org.bmc.tdd;

class Roll {
    private int pins;

    Roll(int pins) {
        if (pins > 10) {
            throw new TooManyPinsException("There may be only 10 pins");
        } else if (pins < 0) {
            throw new LowerThanZeroPinsException("Lower than 0");
        }
        this.pins = pins;
    }

    int getPins() {
        return pins;
    }

    boolean isStrike() {
        return pins == 10;
    }
}
