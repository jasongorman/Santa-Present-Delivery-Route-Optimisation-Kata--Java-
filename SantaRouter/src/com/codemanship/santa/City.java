package com.codemanship.santa;
public class City {	
	
	private final Location location;
	private final int population;
	private final String name;

	public City(Location loc, int population, String name) {
		this.location = loc;
		this.population = population;
		this.name = name;
	}

	public double distance(City city) {
		return location.distance(city.location);
	}

	public int deliver(Santa santa, double hoursRemaining) {
		if(hoursRemaining >= santa.deliveryTimeHours(population))
			return population;
	
		return (int)Math.floor(population * (hoursRemaining / santa.deliveryTimeHours(population)));
	}

	public double presentsPerHour(City from, Santa santa, Sleigh sleigh) {
		return population / 
				(sleigh.travelTime(from, this) + santa.deliveryTimeHours(population));
	}
	
	@Override
	public String toString() {
		return name;
	}

}
