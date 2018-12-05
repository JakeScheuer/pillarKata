package com.pillar.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pillar.Family;

public class FamilyTest {
	@Test
	public void testGetRateBefore11() {
		Family family = new Family();
		assertEquals(15, family.getRateBefore11());
	}

}
