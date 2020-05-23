package org.bmc.tdd;

import java.util.ArrayList;
import java.util.List;

public class Round {
	private List<Roll> rolls = new ArrayList<>();

	public RoundBuilder roll(int pins){
		return new RoundBuilder(pins, this);
	}

	public List<Roll> getRolls(){
		return rolls;
	}

	public class RoundBuilder {

		private Round round;

		public RoundBuilder(int pins, Round round) {
			round.rolls.add(new Roll(pins));
			this.round = round;
		}

		public void roll(int pins){
			round.rolls.add(new Roll(pins));
		}
	}
}
