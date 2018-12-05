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
		payCalculator.resetPayOut();
		shift.setEndTime(3);
		assertEquals(170, payCalculator.calculatePay(family, shift));
	}
	@Test
	public void testCalculatePayForFamilyBOneRateOnly() {
		family.setFamilyName("B");
		shift.setStartTime(5);
		shift.setEndTime(10);
		assertEquals(60, payCalculator.calculatePay(family, shift));
	}
	
	@Test
	public void testCalculatePayForFamilyBFirstTwoRates() {
		family.setFamilyName("B");
		shift.setStartTime(5);
		shift.setEndTime(12);
		assertEquals(76, payCalculator.calculatePay(family, shift));
	}
	@Test
	public void testCalculatePayForFamilyBAllRates() {
		family.setFamilyName("B");
		shift.setStartTime(5);
		shift.setEndTime(4);
		assertEquals(140, payCalculator.calculatePay(family, shift));
	}

}
