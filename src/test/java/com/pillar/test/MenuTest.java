package com.pillar.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.pillar.FamilyA;
import com.pillar.FamilyB;
import com.pillar.FamilyC;
import com.pillar.Menu;

public class MenuTest {
	private ByteArrayOutputStream output;

	@Before
	public void setup() {
		this.output = new ByteArrayOutputStream();
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
	
//	@Test
//	public void validateObjectAfterMakingChoice() {
//		Object[] options = new Object[] {"Conan", "Colbert", "Falon"};
//		Menu menu = getMenuForTestingWithUserInput("2\n");
//		Object result = menu.getChoiceFromOptions(options);
//		Assert.assertEquals("Colbert", result.toString());
//	}
	private Menu getMenuForTestingWithUserInput(String userInput) {
		ByteArrayInputStream input = new ByteArrayInputStream(String.valueOf(userInput).getBytes());
		return new Menu(input, output);
	}
	private Menu getMenuForTesting() {
		return getMenuForTestingWithUserInput("1\n");
	}
	
//	@Test
//	public void testDisplayStartTimePrompt() {
//		Menu menu = getMenuForTesting();
//		menu.displayStartTimePrompt();
//		String expected = "What is your start time? >>> \n";
//		Assert.assertEquals(expected, output.toString());
//	}
//	@Test
//	public void testDisplayEndTimePrompt() {
//		Menu menu = getMenuForTesting();
//		menu.displayEndTimePrompt();
//		String expected = "What is your end time? >>> \n";
//		Assert.assertEquals(expected, output.toString());
//	}
//	@Test
//	public void testDisplayResults() {
//		Menu menu = getMenuForTesting();
//		menu.displayResult();
//		
//		String expected = "You will earn $90\n";
//		Assert.assertEquals(expected, output.toString());
//	}
//	@Test
//	public void validateObjectAfterMakingChoice() {
//		Object[] options = new Object[] {"Conan", "Colbert", "Falon"};
//		Menu menu = getMenuForTestingWithUserInput("2\n");
//		Object result = menu.getChoiceFromOptions(options);
//		Assert.assertEquals("Colbert", result.toString());
//	}
//	@Test
//	public void validateStartTimeInput() {
//		Menu menu = getMenuForTestingWithUserInput("7\n");
//		menu.getStartTimeFromUserInput();
//		Assert.assertEquals(7, menu.getShift().getStartTime());
//	}
//	@Test
//	public void validateEndTimeInput() {
//		Menu menu = getMenuForTestingWithUserInput("10\n");
//		menu.getEndTimeFromUserInput();
//		Assert.assertEquals(10, menu.getShift().getEndTime());
//	}
//	
//	private Menu getMenuForTestingWithUserInput(String userInput) {
//		ByteArrayInputStream input = new ByteArrayInputStream(String.valueOf(userInput).getBytes());
//		return new Menu(input, output);
//	}
//
//	private Menu getMenuForTesting() {
//		return getMenuForTestingWithUserInput("1\n");
//	}
}
