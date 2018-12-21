import static org.junit.Assert.*;

import org.junit.Test;

public class RoutePermutationsTest {
	
	@Test
	public void singleCityHasOnePermutation() {
		City[] cities = new City[] {new City(new Location(0,0), 1)};
		assertEquals(1, HeapsPermuter.permute(cities).length);
	}
	
	@Test
	public void twoCitiesHaveTwoPermutations() {
		City city1 = new City(new Location(0,0), 1);
		City city2 = new City(new Location(0,0), 1);
		City[] cities = new City[] {city1, city2};
		assertEquals(2, HeapsPermuter.permute(cities).length);
	}
	
	@Test
	public void threeCitiesHaveSixPermutations() {
		City city1 = new City(new Location(0,0), 1);
		City city2 = new City(new Location(0,0), 1);
		City city3 = new City(new Location(0,0), 1);
		City[] cities = new City[] {city1, city2, city3};
		assertEquals(6, HeapsPermuter.permute(cities).length);
	}
	
	@Test
	public void fourCitiesHaveTwentyFourPermutations() {
		City city1 = new City(new Location(0,0), 1);
		City city2 = new City(new Location(0,0), 1);
		City city3 = new City(new Location(0,0), 1);
		City city4 = new City(new Location(0,0), 1);
		City[] cities = new City[] {city1, city2, city3, city4};
		Object[][] permutations = HeapsPermuter.permute(cities);
		assertEquals(24, permutations.length);
	}
	
	@Test
	public void permutatonsOfThreeNumbers() {
		Object[][] permutations = HeapsPermuter.permute(new Object[] {1,2,3});
		assertEquals(6, permutations.length);
	}

}
