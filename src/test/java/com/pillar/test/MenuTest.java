package com.pillar.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.pillar.Menu;

public class MenuTest {
	private ByteArrayOutputStream output;
	
	@Before
	public void setup() {
		output = new ByteArrayOutputStream();
	}
	
	@Test
	public void testDisplayListOfMenuOptions() {
		Object[] options = new Object[] {"Family A","Family B","Family C"};
		Menu menu = getMenuForTesting();
		String result = menu.displayOptions(options);
		String expected = "\n"+
		 		  "1) "+options[0]+"\n" + 
				  "2) "+options[1]+"\n" +
				  "3) "+options[2]+"\n\n" +
				  "Please choose which family you'll be working for >>> ";
		Assert.assertEquals(expected, result);
	}
	@Test
	public void testDisplayStartTimePrompt() {
		Menu menu = getMenuForTesting();
		String result = menu.displayStartTimePrompt();
		String expected = "What is your start time? >>> ";
		Assert.assertEquals(expected, result);
	}
	@Test
	public void testDisplayEndTimePrompt() {
		Menu menu = getMenuForTesting();
		String result = menu.displayEndTimePrompt();
		String expected = "What is your end time? >>> ";
		Assert.assertEquals(expected, result);
	}
	@Test
	public void testDisplayResults() {
		Menu menu = getMenuForTesting();
		String result = menu.displayResult();
		String expected = "Working for Family A from 5 to 11 will earn you $90";
		Assert.assertEquals(expected, result);
	}
	@Test
	public void validateObjectAfterMakingChoice() {
		Object[] options = new Object[] {"Conan", "Colbert", "Falon"};
		Menu menu = getMenuForTestingWithUserInput("2\n");
		Object result = menu.getChoiceFromOptions(options);
		Assert.assertEquals("Colbert", result.toString());
	}
	@Test
	public void validateStartTimeInput() {
		Menu menu = getMenuForTestingWithUserInput("7\n");
		menu.getStartTimeFromUserInput();
		Assert.assertEquals(7, menu.shift.getStartTime());
	}
	
	private Menu getMenuForTestingWithUserInput(String userInput) {
		ByteArrayInputStream input = new ByteArrayInputStream(String.valueOf(userInput).getBytes());
		return new Menu(input, output);
	}

	private Menu getMenuForTesting() {
		return getMenuForTestingWithUserInput("1\n");
	}
}
