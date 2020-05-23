package org.bmc.tdd;

import java.util.*;
import java.util.stream.Collectors;

class GameManager extends LinkedList<Round> {

	Round nextGame() {
		return addAndReturn(new Round());
	}

	private Round addAndReturn(Round round) {

//		if(size() == 10 && getScore() != 290){
//			throw new TooManyRoundsException("When not all rolls is strike, available only 10 rounds");
//		}

		add(round);
		return round;
	}

	int getScore() {
		int score = 0;
		List<Roll> rolls = stream().filter(Objects::nonNull).map(Round::getRolls).flatMap(f -> Arrays.stream(f)).collect(Collectors.toList());

		for (int i = 0, rollIndex = 0; i < 10; i++) {
			Optional<Roll> roll = rolls.size() <= rollIndex ?Optional.empty() : Optional.ofNullable(rolls.get(rollIndex));

			if (isStrike(roll)) {
				score += getValue(roll) + getRollValue(rollIndex + 1, rolls) + getRollValue(rollIndex + 2, rolls);
				rollIndex += 1;
			} else if (isSpare(rollIndex, rolls)) {
				score += 10 + getRollValue(rollIndex + 2, rolls);
				rollIndex += 2;
			} else {
				score += getValue(roll);
				rollIndex += 1;
			}
		}

		return score;
	}

	private Boolean isStrike(Optional<Roll> roll) {
		return roll.map(Roll::isStrike).orElse(false);
	}

	private Integer getValue(Optional<Roll> roll) {
		return roll.map(Roll::getPins).orElse(0);
	}

	private boolean isSpare(int i, List<Roll> rolls) {
		Integer roll1 = getRollValue(i, rolls);
		Integer roll2 = getRollValue(i + 1, rolls);

		return roll1 + roll2 == 10;
	}

	private int getRollValue(int rollIndex, List<Roll> rolls) {

		if(rolls.size() <= rollIndex){
			return 0;
		}

		return Optional.ofNullable(rolls.get(rollIndex)).map(Roll::getPins).orElse(0);
	}
}
