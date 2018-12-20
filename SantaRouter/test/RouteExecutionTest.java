import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;

public class RouteExecutionTest {

	@Test
	public void routeWithNoCitiesDeliversZeroPresents() {
		List<City> route = new ArrayList<>();
		double hoursAvailable = 1.0;
		assertEquals(0, new DeliveryRoute(route, new Santa(1), hoursAvailable, new Sleigh(3000)).execute( ));
	}
	
	@Test
	public void noPresentsDeliveredWhenNoTimeAvailable() {
		int population = 1000;
		double hoursAvailable = 0;
		City city = new City(new Location(0,0), population);
		List<City> route = Arrays.asList(new City[] {city});
		assertEquals(0, new DeliveryRoute(route, new Santa(1), hoursAvailable, new Sleigh(3000)).execute( ));
	}
	
	@Test
	public void routeWithOneCityAndEnoughTimeDeliversToWholePopulation() {
		int population = 1000;
		double hoursAvailable = 1.0;
		int secondsPerPresent = 1;
		City city = new City(new Location(0,0), population);
		List<City> route = Arrays.asList(new City[] {city});
		assertEquals(1000, new DeliveryRoute(route, new Santa(secondsPerPresent), hoursAvailable, new Sleigh(3000)).execute( ));
	}
	
	@Test
	public void routeWithTwoCitiesNoDistanceApartAndEnoughTimeDeliversToWholePopulation() {
		int population = 1000;
		double hoursAvailable = 2.0;
		int secondsPerPresent = 1;
		City city1 = new City(new Location(0,0), population);
		City city2 = new City(new Location(0,0), population);
		List<City> route = Arrays.asList(new City[] {city1, city2});
		assertEquals(2000, new DeliveryRoute(route, new Santa(secondsPerPresent), hoursAvailable, new Sleigh(3000)).execute( ));
	}
	
	@Test
	public void routeWithTwoCitiesNoDistanceApartButInsufficientTimeDeliversToProportionOfSecondCity() {
		int population = 3600;
		double hoursAvailable = 1.5;
		int secondsPerPresent = 1;
		City city1 = new City(new Location(0,0), population);
		City city2 = new City(new Location(0,0), population);
		List<City> route = Arrays.asList(new City[] {city1, city2});
		assertEquals(5400, new DeliveryRoute(route, new Santa(secondsPerPresent), hoursAvailable, new Sleigh(3000)).execute( ));
	}
	
	@Test
	public void routeWithTwoCitiesAnHourApartIncludesTravelTime() {
		int population = 3600;
		double hoursAvailable = 2.0;
		int secondsPerPresent = 1;
		
		City city1 = new City(new Location(0,0), population);		
		
		// create a stub city2 exactly 1 hour from city1 by sleigh travelling 3000 kph
		City city2 = mock(City.class);
		when(city2.deliver(any(), anyDouble())).thenReturn(3600);
		when(city2.distance(any())).thenReturn(3000.0);
		
		List<City> route = Arrays.asList(new City[] {city1, city2});
		
		// shouldn't have time left to deliver any presents in city2
		assertEquals(3600, new DeliveryRoute(route, new Santa(secondsPerPresent), hoursAvailable, new Sleigh(3000)).execute( ));
	}

}
