package com.codemanship.santa;

public class Sleigh {

	private final double speed;

	public Sleigh(double speed) {
		this.speed = speed;
	}

	public double travelTime(City from, City to) {
		if(from == null)
			return 0;
		return from.distance(to)/speed;
	}

}
