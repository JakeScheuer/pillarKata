package com.pillar.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.pillar.Menu;

public class MenuTest {
	
	Menu menu;
	
	@Before
	public void setup() {
		this.menu = new Menu();
	}
	
	@Test
	public void testDisplayListOfMenuOptions() {
		Object[] options = new Object[] {"Family A","Family B","Family C"};
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
		String result = menu.displayStartTimePrompt();
		String expected = "What is your start time? >>> ";
		Assert.assertEquals(expected, result);
	}
	@Test
	public void testDisplayEndTimePrompt() {
		String result = menu.displayEndTimePrompt();
		String expected = "What is your end time? >>> ";
		Assert.assertEquals(expected, result);
	}
	@Test
	public void testDisplayResults() {
		String result = menu.displayResult();
		String expected = "Working for Family A from 5 to 11 will earn you $90";
		Assert.assertEquals(expected, result);
	}
}
