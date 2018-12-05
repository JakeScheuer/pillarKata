package com.pillar.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.pillar.Family;

public class FamilyTest {
	Family family;
	@Before
	public void setup() {
		family = new Family();
	}
	@Test
	public void testGetRateBefore11() {
		assertEquals(15, family.getRate(0));
	}
	@Test
	public void testGetRateAfter11() {
		assertEquals(20, family.getRate(1));
	}
	@Test
	public void verifySetAndGetFamilyName() {
		family.setFamilyName("A");
		assertEquals("A",family.getFamilyName());
	}

}
