package com.pillar.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import com.pillar.Shift;

public class ShiftTest {
	Shift shift;
	
	@Before
	public void setup() {
		shift = new Shift();
	}
	
	@Test
	public void testSetAndGetStartTime() {
		shift.setStartTime(5);
		assertEquals(5, shift.getStartTime());
	}
	@Test
	public void doNotAllowStartToBeEarlierThan5PM() {
		shift.setStartTime(1);
		assertEquals(0, shift.getStartTime());
	}
	
	@Test
	public void startTimeCannotBeMidnightSinceItIsConsideredEarlierThan5Pm() {
		shift.setStartTime(12);
		assertEquals(0, shift.getStartTime());
	}
	
	@Test 
	public void startTimeMustBeInRange() {
		shift.setStartTime(25);
		assertEquals(0, shift.getStartTime());
	}
	
	@Test
	public void testSetAndGetEndTime() {
		shift.setEndTime(10);
		assertEquals(10, shift.getEndTime());
	}
	
	@Test
	public void calculateTotalHoursByTakingDifferenceOfStartAndEndTimes() {
		shift.setStartTime(5);
		shift.setEndTime(11);
		assertEquals(6, shift.calculateTotalHours());
	}
	
	@Test
	public void calculateTotalHoursIfEndTimeIsPastMidnight() {
		shift.setStartTime(6);
		shift.setEndTime(1);
		assertEquals(7, shift.calculateTotalHours());
	}
	
}
