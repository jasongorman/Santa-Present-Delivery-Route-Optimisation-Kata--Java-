package com.codemanship.santa;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RouteBuilder {
	
	private final Santa santa;
	private final Sleigh sleigh;
	private City current;
	private final List<City> unvisitedCities;

	public RouteBuilder(Santa santa, Sleigh sleigh, City current, List<City> cities) {
		this.santa = santa;
		this.sleigh = sleigh;
		this.current = current;
		this.unvisitedCities = cities;
	}

	City next() {
		return unvisitedCities.stream()
				.max(Comparator.comparing(c -> ((City)c).presentsPerHour(current, santa, sleigh)))
				.get();
	}

	public DeliveryRoute build() {
		List<City> route = new ArrayList<>();
		while(!unvisitedCities.isEmpty()) {
			current = next();
			route.add(current);
			unvisitedCities.remove(current);
		}
		return new DeliveryRoute(route, santa, 0, sleigh);
	}
}