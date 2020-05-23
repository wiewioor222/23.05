package org.bmc.tdd;

public class TooManyPinsException extends RuntimeException {
	public TooManyPinsException(String message){
		super(message);
	}
}
