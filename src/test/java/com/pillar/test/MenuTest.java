package com.pillar.test;

import org.junit.Assert;
import org.junit.Test;

import com.pillar.Menu;

public class MenuTest {
	
	@Test
	public void displayListOfMenuOptionsAndPromptsUserToMakeChoice() {
		Object[] options = new Object[] {"Family A","Family B","Family C"};
		Menu menu = new Menu();
		String result = menu.displayOptions(options);
		String expected = "\n"+
		 		  "1) "+options[0].toString()+"\n" + 
				  "2) "+options[1].toString()+"\n" +
				  "3) "+options[2].toString()+"\n\n" +
				  "Please choose which family you'll be working for >>> ";
		Assert.assertEquals(expected, result);
	}

}
