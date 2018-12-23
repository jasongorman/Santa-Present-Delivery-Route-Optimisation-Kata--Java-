package com.codemanship.santa;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RouteBuilder {
	
	private final Santa santa;
	private final Sleigh sleigh;
	private City current;
	private final List<City> unvisitedCities;
	private double hoursAvailable;

	public RouteBuilder(Santa santa, Sleigh sleigh, List<City> cities, double hoursAvailable) {
		this.santa = santa;
		this.sleigh = sleigh;
		this.unvisitedCities = cities;
		this.hoursAvailable = hoursAvailable;
	}
	
	// internal constructor for testing next()
	RouteBuilder(Santa santa, Sleigh sleigh, City current, List<City> cities, double hoursAvailable) {
		this(santa, sleigh, cities, hoursAvailable);
		this.current = current;
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
		return new DeliveryRoute(route, santa, hoursAvailable, sleigh);
	}
}