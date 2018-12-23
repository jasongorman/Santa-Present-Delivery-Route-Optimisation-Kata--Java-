package com.codemanship.santa;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.codemanship.santa.City;
import com.codemanship.santa.RouteBuilder;
import com.codemanship.santa.Santa;
import com.codemanship.santa.Sleigh;

public class RouteBuilderTest {

	@Test
	public void presentsPerHourIncludesTravelTime() {
		Sleigh sleigh = new Sleigh(1000);
		Santa santa = new Santa(1);
		City to = new City(null, 3600); // 1 hour delivery time
		City from = mock(City.class);
		when(from.distance(to)).thenReturn(1000.0); // 1 hour travel time
		assertEquals(1800, to.presentsPerHour(from, santa, sleigh), 0);
	}
	
	@Test
	public void selectsNextCityWithHighestPresentsPerHour() {
		City current = new City(null, 0);
		City city1 = mock(City.class);
		City city2 = mock(City.class);
		City highest = mock(City.class);
		when(city1.presentsPerHour(any(), any(), any())).thenReturn(500.0);
		when(city2.presentsPerHour(any(), any(), any())).thenReturn(700.0);
		when(highest.presentsPerHour(any(), any(), any())).thenReturn(1000.0);
		List<City> unvisitedCities = Arrays.asList(city1 , highest, city2);
		assertSame(highest, new RouteBuilder(null, null, current, unvisitedCities).findNext());
	}

}
