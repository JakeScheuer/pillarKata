package com.pillar.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.pillar.FamilyB;
import com.pillar.Shift;

public class FamilyBTest {
	
	FamilyB familyB;
	Shift shift;
	
	@Before
	public void setup() {
		familyB = new FamilyB();
		shift = new Shift();
	}
	
	@Test
	public void testCalculatePayForFamilyBOneRateOnly() {
		shift.setStartTime(5);
		shift.setEndTime(10);
		assertEquals(60, familyB.calculatePay(shift));
	}
	@Test
	public void testCalculatePayForFamilyBFirstTwoRates() {
		shift.setStartTime(5);
		shift.setEndTime(12);
		assertEquals(76, familyB.calculatePay(shift));
	}
	@Test
	public void testCalculatePayForFamilyBAllRates() {
		shift.setStartTime(5);
		shift.setEndTime(4);
		assertEquals(140, familyB.calculatePay(shift));
	}
	@Test
	public void testCalculatePayForFamilyBLastTwoRates() {
		shift.setStartTime(10);
		shift.setEndTime(4);
		assertEquals(80, familyB.calculatePay(shift));
	}

}
