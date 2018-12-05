package com.pillar.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.pillar.FamilyA;
import com.pillar.Shift;

public class FamilyATest {
	
	FamilyA familyA;
	Shift shift;
	
	@Before
	public void setup() {
		familyA = new FamilyA();
		shift = new Shift();
	}
	
	@Test
	public void testCalculatePayForFamilyAOneRateOnly() {
		shift.setStartTime(5);
		shift.setEndTime(11);
		assertEquals(90, familyA.calculatePay(shift));
	}
	@Test
	public void testCalculatePayForFamilyABothRatesTillMidnight() {
		shift.setStartTime(5);
		shift.setEndTime(12);
		assertEquals(110, familyA.calculatePay(shift));
	}
	@Test
	public void testCalculatePayForFamilyABothRatesAfterMidnight() {
		shift.setStartTime(5);
		shift.setEndTime(3);
		assertEquals(170, familyA.calculatePay(shift));
	}
}
