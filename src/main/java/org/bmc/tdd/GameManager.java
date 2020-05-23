package org.bmc.tdd;

import java.util.*;
import java.util.stream.Collectors;

class GameManager extends LinkedList<Round> {

	Round nextGame() {
		Round round =  new Round();
		add(round);

		return round;
	}

	int getScore() {

		int score = 0;
		List<Roll> rolls = stream().filter(Objects::nonNull).map(Round::getRolls).flatMap(f -> Arrays.stream(f)).collect(Collectors.toList());

		for (int i = 0, rollIndex = 0; i < 10; i++) {

			if (isStrike(rollIndex,rolls)){

				score = getRollValue(rollIndex, rolls) + getRollValue(rollIndex+1, rolls)+ getRollValue(rollIndex+2, rolls);
				rollIndex+=1;
			}


			else if(isSpare(rollIndex, rolls)){
				score += 10 + getRollValue(rollIndex, rolls);
				rollIndex +=2;
			} else {
				score += getRollValue(rollIndex, rolls) + getRollValue(rollIndex + 1, rolls);
				rollIndex +=2;
			}

		}

		return score;
	}

	private boolean isSpare(int i, List<Roll> rolls) {
		Integer roll1 = getRollValue(i, rolls);
		Integer roll2 = getRollValue(i + 1, rolls);

		return roll1 + roll2 == 10;
	}

	private boolean isStrike(int i, List<Roll> rolls) {
		Integer roll1 = getRollValue(i, rolls);

		return roll1 == 10;
	}


	private int getRollValue(int rollIndex, List<Roll> rolls) {

		if(rolls.size() <= rollIndex){
			return 0;
		}

		return Optional.ofNullable(rolls.get(rollIndex)).map(Roll::getPins).orElse(0);
	}

	private int getRollValueAndNext(int rollIndex, List<Roll> rolls) {

		if(rolls.size() <= rollIndex){
			return 0;
		}

		int value = Optional.ofNullable(rolls.get(rollIndex)).map(Roll::getPins).orElse(0);

		rollIndex++;
		return value;
	}
}
