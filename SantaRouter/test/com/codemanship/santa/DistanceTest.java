package com.codemanship.santa;
import static org.junit.Assert.*;

import org.junit.Test;

import com.codemanship.santa.City;
import com.codemanship.santa.Location;


public class DistanceTest {

	@Test
	public void locationIsZeroKmFromItself() {
		Location location = new Location(0.0, 0.0);
		assertEquals(0, new City(location, 0).distance(new City(location, 0)), 0.0);
	}
	
	@Test
	public void newYorkToLosAngeles() {
		City newYork = new City(new Location(40.6635, -73.9387), 0);
		City losAngeles = new City(new Location(34.0194, -118.4108), 0);
		assertEquals(3957, newYork.distance(losAngeles), 1.0); // within 1km
	}
	
	@Test
	public void houstonToPhoenix() {
		City houston = new City(new Location(41.8376, -87.6818), 0);
		City phoenix = new City(new Location(33.5722, -112.0901), 0);
		assertEquals(2325, houston.distance(phoenix), 1.0);
	}
	
	@Test
	public void sanDiegoToChicago() {
		City sanDiego = new City(new Location(32.8153, -117.1350), 0);
		City chicago = new City(new Location(41.8376, -87.6818), 0);
		assertEquals(2774, sanDiego.distance(chicago), 1.0);
	}

}
