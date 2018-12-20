import static org.junit.Assert.*;

import org.junit.Test;

public class PresentsDeliveredTest {

	@Test
	public void inCityWithNoPopulationZeroPresentsAreDelivered() {
		int population = 0;
		City city = new City(null, population);
		assertEquals(population, city.deliver(new Santa(1), 1));
	}
	
	@Test
	public void withSufficientTimeWholePopulationReceivesPresents() {
		int population = 1000;
		double secondsPerPresent = 1;
		double hoursRemaining = (population * secondsPerPresent)/3600;
		assertEquals(population, new City(null, population).deliver(new Santa(secondsPerPresent) , hoursRemaining ));
	}
	
	@Test
	public void withNoTimeRemainingZeroPresentsAreDelivered() throws Exception {
		int hoursRemaining = 0;
		assertEquals(hoursRemaining, new City(null, 1000).deliver(new Santa(1), hoursRemaining));
	}
	
	@Test
	public void halfThePresentsWillBeDeliveredInHalfTheRequiredTimeForCity() {
		int population = 3600;
		double hoursRemaining = 0.5;
		int secondsPerPresent = 1;
		assertEquals(1800, new City(null, population).deliver(new Santa(secondsPerPresent), hoursRemaining));
	}
	
	@Test
	public void whenMoreTimThanNeededEntirePopulationGetsPresents() {
		int population = 3600;
		double hoursRemaining = 2;
		int secondsPerPresent = 1;
		assertEquals(3600, new City(null, population).deliver(new Santa(secondsPerPresent), hoursRemaining));
	}

}
