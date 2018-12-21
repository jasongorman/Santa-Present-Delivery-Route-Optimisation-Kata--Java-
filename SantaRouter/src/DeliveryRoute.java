import java.util.List;

public class DeliveryRoute {
	
	private final List<City> cities;
	private final Santa santa;
	private final double hoursAvailable;
	private final Sleigh sleigh;

	public DeliveryRoute(List<City> cities, Santa santa, double hoursAvailable, Sleigh sleigh) {
		this.cities = cities;
		this.santa = santa;
		this.hoursAvailable = hoursAvailable;
		this.sleigh = sleigh;
	}

	int execute() {
		double hoursRemaining = hoursAvailable;
		int presentsDelivered = 0;
		City lastVisited = null;
		
		for (City city : cities) {
			hoursRemaining = deductTravelTime(hoursRemaining, lastVisited, city);
			if(hoursRemaining <= 0)
				break;
			int cityPresents = city.deliver(santa, hoursRemaining);
			presentsDelivered += cityPresents;
			hoursRemaining -= santa.deliveryTimeHours(cityPresents);
			lastVisited = city;
		}
		return presentsDelivered;
	}

	private double deductTravelTime(double hoursRemaining, City lastVisited, City city) {
		if(lastVisited != null)
			hoursRemaining -= sleigh.travelTime(city, lastVisited);
		return hoursRemaining;
	}
}