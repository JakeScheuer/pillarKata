package com.pillar.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.pillar.FamilyC;
import com.pillar.Shift;

public class FamilyCTest {
	
	FamilyC familyC;
	Shift shift;
	
	@Before
	public void setup() {
		familyC = new FamilyC();
		shift = new Shift();
	}
	
	@Test
	public void testCalculatePayForFamilyCOneRate() {
		shift.setStartTime(5);
		shift.setEndTime(9);
		assertEquals(84, familyC.calculatePay(shift));
	}
	@Test
	public void testCalculatePayForFamilyCRateAfter9Till12() {
		shift.setStartTime(9);
		shift.setEndTime(12);
		assertEquals(45, familyC.calculatePay(shift));
	}
	@Test
	public void testCalculatePayForFamilyCRateAfter9Till4() {
		shift.setStartTime(9);
		shift.setEndTime(4);
		assertEquals(105, familyC.calculatePay(shift));
	}

}
