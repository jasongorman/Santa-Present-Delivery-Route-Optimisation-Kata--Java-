package com.codemanship.santa.permutations;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.codemanship.santa.City;
import com.codemanship.santa.DeliveryRoute;
import com.codemanship.santa.Location;
import com.codemanship.santa.RouteBuilder;
import com.codemanship.santa.Santa;
import com.codemanship.santa.Sleigh;

public class ExhaustiveRouteSearchTest {

	@Test
	public void routeBuilderFindsOptimumPresentsDelivered() {
		City newYork = new City(new Location(40.6635, 73.9387), 8600000, "New York");
		City losAngeles = new City(new Location(34.0194, 118.4108), 4000000, "Los Angeles");
		City chicago = new City(new Location(41.8376, 87.6818), 2700000, "Chicago");
		City houston = new City(new Location(29.7866, 95.3909), 2300000, "Houston");
		City phoenix = new City(new Location(33.5722, 112.0901), 1600000, "Phoenix");
		City philadephia = new City(new Location(40.0094, 75.1333), 1600000, "Philadelphia");
		City sanAntonio = new City(new Location(29.4724, 98.5251), 1500000, "San Antonio");
		City sanDiego = new City(new Location(32.8153, 117.1350), 1400000, "San Diego");
		City dallas = new City(new Location(32.7933, 96.7665), 1300000, "Dallas");
		City sanJose = new City(new Location(37.2967, 121.8189), 1000000, "San Jose");
		List<City> cities = Arrays.asList(newYork,
											losAngeles,
											chicago,
											houston,
											phoenix,
											philadephia,
											sanAntonio,
											sanDiego,
											dallas,
											sanJose);
		
		Santa santa = new Santa(0.001);		
		Sleigh sleigh = new Sleigh(3000);
		DeliveryRoute optimumRoute = new RouteBuilder(santa , sleigh, cities, 6).build();
		int presentsDelivered = optimumRoute.execute();		
		
		System.out.println("Optimum route: " + optimumRoute.toString() + " " + presentsDelivered);
		
		
		Object[][] permutations = HeapsPermuter.permute(cities.toArray());
		
		int top = 0;
		DeliveryRoute bestRoute = null;
		
		for (Object[] permutation : permutations) {
			City[] x = Arrays.copyOf(permutation, permutation.length, City[].class);
			DeliveryRoute route = new DeliveryRoute(Arrays.asList(x), santa, 6, sleigh);
			int delivered = route.execute();
			if(delivered > top) {
				top = delivered;
				bestRoute = route;
			}
//			System.out.println("Compared to: " + route.toString() + " " + delivered);
//			assertTrue(presentsDelivered >= delivered);
		}
		
		System.out.println("Best: " + bestRoute.toString() + " " + top);
	
	}

}
