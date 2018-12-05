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

}
