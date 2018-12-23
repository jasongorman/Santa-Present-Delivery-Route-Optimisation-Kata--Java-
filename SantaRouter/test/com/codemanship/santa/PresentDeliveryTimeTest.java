package com.codemanship.santa;
import static org.junit.Assert.*;

import org.junit.Test;

import com.codemanship.santa.Santa;

public class PresentDeliveryTimeTest {

	@Test
	public void takesNoTimeToDeliverNoPresents() {
		assertEquals(0, new Santa(0.001).deliveryTimeHours(0 ), 0.0);
	}
	
	@Test
	public void takesOneSecondToDeliverOneThousandPresents() {
		assertEquals((double)1/3600, new Santa(0.001).deliveryTimeHours(1000), 0.0);
	}

}
