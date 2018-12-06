package com.pillar.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.pillar.FamilyA;
import com.pillar.Menu;
import com.pillar.Payable;
import com.pillar.Shift;

public class MenuTest {
	private ByteArrayOutputStream output;

	@Before
	public void setup() {
		this.output = new ByteArrayOutputStream();
	}
	@Test 
	public void testDisplayGreeting() {
		Menu menu = getMenuForTesting();
		menu.displayGreeting();
		String expected = "Welcome Babysitter!\n" + 
						"I can help you calculate your pay for one night of work!\n\n" + 
						"Now tell me, which family will you be working for?\n";
		Assert.assertEquals(expected, output.toString());
	}
	@Test
	public void testDisplayListOfMenuOptions() {
		Menu menu = getMenuForTesting();
		menu.displayOptions();
		String expected = "\n"+
		 		  "1) Family A\n" + 
				  "2) Family B\n" +
				  "3) Family C\n\n" +
				  "Please choose which family you'll be working for >>> ";
		Assert.assertEquals(expected, output.toString());
	}
	@Test
	public void validateObjectAfterMakingChoice() {
		Menu menu = getMenuForTestingWithUserInput("2\n");
		Payable result = menu.getChoiceFromOptions();
		Assert.assertEquals("FamilyB", result.getClass().getSimpleName());
	}
	@Test
	public void testDisplayStartTimePrompt() {
		Menu menu = getMenuForTesting();
		menu.displayStartTimePrompt();
		String expected = "What is your start time? >>> \n";
		Assert.assertEquals(expected, output.toString());
	}
	@Test
	public void validateStartTimeInput() {
		Menu menu = getMenuForTestingWithUserInput("7\n");
		int result = menu.getStartTimeFromUserInput();
		Assert.assertEquals(7, result);
	}
	@Test
	public void testDisplayEndTimePrompt() {
		Menu menu = getMenuForTesting();
		menu.displayEndTimePrompt();
		String expected = "What is your end time? >>> \n";
		Assert.assertEquals(expected, output.toString());
	}
	@Test
	public void validateEndTimeInput() {
		Menu menu = getMenuForTestingWithUserInput("10\n");
		int result = menu.getEndTimeFromUserInput(5);
		Assert.assertEquals(10, result);
	}
	@Test
	public void testDisplayResults() {
		Menu menu = getMenuForTesting();
		FamilyA family = new FamilyA();
		Shift shift = new Shift();
		shift.setStartTime(5);
		shift.setEndTime(11);
		menu.displayResult(family, shift);
		String expected = "Working for FamilyA from 5 to 11 will earn you $90\n";
		Assert.assertEquals(expected, output.toString());
	}
	@Test
	public void testDisplayEndingOptions() {
		Menu menu = getMenuForTesting();
		menu.displayEndingOptions();
		String expected = "Would you like to do another calculation? (Y/N) >>> \n";
		Assert.assertEquals(expected, output.toString());
	}
	@Test
	public void validateEndingInput() {
		Menu menu = getMenuForTestingWithUserInput("Y\n");
		boolean toEnd = menu.getToRun();
		Assert.assertEquals(true, toEnd);
	}
	@Test
	public void testDisplayGoodbyeMessage() {
		Menu menu = getMenuForTesting();
		menu.displayGoodbyeMessage();
		String expected = "Have a Great Day!";
		Assert.assertEquals(expected, output.toString());
	}
	private Menu getMenuForTestingWithUserInput(String userInput) {
		ByteArrayInputStream input = new ByteArrayInputStream(String.valueOf(userInput).getBytes());
		return new Menu(input, output);
	}
	private Menu getMenuForTesting() {
		return getMenuForTestingWithUserInput("1\n");
	}
}
