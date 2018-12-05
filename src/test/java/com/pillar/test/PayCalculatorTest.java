package com.pillar.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pillar.Family;
import com.pillar.PayCalculator;
import com.pillar.Shift;

public class PayCalculatorTest {
	@Test
	public void testCalculateRateFamilyAOneRateOnly() {
		Family family = new Family();
		Shift shift = new Shift();
		PayCalculator payCalculator = new PayCalculator();
		family.setFamilyName("A");
		shift.setStartTime(5);
		shift.setEndTime(11);
		assertEquals(90, payCalculator.calculatePay(family, shift));
	}


}
