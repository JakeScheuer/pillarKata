package com.pillar.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.pillar.Shift;

public class ShiftTest {
	@Test
	public void testSetAndGetStartTime() {
		Shift shift = new Shift();
		shift.setStartTime(5);
		assertEquals(5, shift.getStartTime());
	}
}
