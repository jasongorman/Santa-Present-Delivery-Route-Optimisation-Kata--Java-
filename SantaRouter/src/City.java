public class City {	
	
	private final Location location;
	private final int population;

	public City(Location loc, int population) {
		this.location = loc;
		this.population = population;
	}

	public double distance(City city) {
		return location.distance(city.location);
	}

	public int deliver(Santa santa, double hoursRemaining) {
		if(hoursRemaining >= santa.deliveryTimeHours(population))
			return population;
	
		return (int)Math.floor(population * (hoursRemaining / santa.deliveryTimeHours(population)));
	}

}
