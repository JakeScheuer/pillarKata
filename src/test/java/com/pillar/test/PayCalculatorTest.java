package com.pillar.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.pillar.Family;
import com.pillar.PayCalculator;
import com.pillar.Shift;

public class PayCalculatorTest {
	Family family;
	Shift shift;
	PayCalculator payCalculator;
	
	@Before
	public void setup() {
		family = new Family();
		shift = new Shift();
		payCalculator = new PayCalculator();
	}
	
	@Test
	public void testCalculatePayForFamilyAOneRateOnly() {
		family.setFamilyName("A");
		shift.setStartTime(5);
		shift.setEndTime(11);
		assertEquals(90, payCalculator.calculatePay(family, shift));
	}
	@Test
	public void testCalculatePayForFamilyABothRates() {
		family.setFamilyName("A");
		shift.setStartTime(5);
		shift.setEndTime(12);
		assertEquals(110, payCalculator.calculatePay(family, shift));
	}

}
