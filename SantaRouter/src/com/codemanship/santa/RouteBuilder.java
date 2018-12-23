package com.codemanship.santa;
import java.util.Comparator;
import java.util.List;

public class RouteBuilder {
	
	private Santa santa;
	private Sleigh sleigh;
	private City current;
	private List<City> unvisitedCities;

	public RouteBuilder(Santa santa, Sleigh sleigh, City current, List<City> unvisitedCities) {
		this.santa = santa;
		this.sleigh = sleigh;
		this.current = current;
		this.unvisitedCities = unvisitedCities;
	}

	City findNext() {
		return unvisitedCities.stream()
				.max(Comparator.comparing(c -> ((City)c).presentsPerHour(current, santa, sleigh)))
				.get();
	}
}