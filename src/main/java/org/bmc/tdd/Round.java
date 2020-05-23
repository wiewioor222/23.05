package org.bmc.tdd;

public class Round {
	private Roll[] rolls = new Roll[2];

	public RoundBuilder roll(int pins){
		return new RoundBuilder(pins, this);
	}

	public Roll[] getRolls(){
		return rolls;
	}

	public class RoundBuilder {

		private Round round;

		public RoundBuilder(int pins, Round round) {
			round.rolls[0] = new Roll(pins);
			this.round = round;
		}

		public void roll(int pins){
			round.rolls[1] = new Roll(pins);
		}
	}
}
