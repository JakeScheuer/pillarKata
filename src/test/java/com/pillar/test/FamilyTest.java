package com.pillar.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pillar.Family;

public class FamilyTest {
	@Test
	public void testGetRateBefore11() {
		Family family = new Family();
		assertEquals(15, family.getRate(0));
	}
	@Test
	public void testGetRateAfter11() {
		Family family = new Family();
		assertEquals(20, family.getRate(1));
	}

}
