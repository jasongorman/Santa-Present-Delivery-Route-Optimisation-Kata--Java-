package com.codemanship.santa;
import static org.junit.Assert.*;

import org.junit.Test;

import com.codemanship.santa.City;
import com.codemanship.santa.Location;
import com.codemanship.santa.Sleigh;

public class TravelTimeTest {

	@Test
	public void travelTimeToSameCityIsZero() {
		City city = new City(new Location(0,0), 0, "");
		assertEquals(0.0, new Sleigh(3000).travelTime(city, city), 0.0);
	}
	
	@Test
	public void travelTimeNewYorkToLosAngeles() {
		City newYork = new City(new Location(40.6635, -73.9387), 0, "");
		City losAngeles = new City(new Location(34.0194, -118.4108), 0, "");
		assertEquals((double)3957/3000, new Sleigh(3000).travelTime(newYork, losAngeles), (double)1/3600); // to nearest second
	}
	
	@Test
	public void firstCityVisitedHasZeroTravelTime() {
		Sleigh sleigh = new Sleigh(1000);
		City to = new City(null, 3600, "");
		assertEquals(0, sleigh.travelTime(null, to), 0);
	}

}
