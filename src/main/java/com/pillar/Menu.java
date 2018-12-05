package com.pillar;

public class Menu {

	public String displayOptions(Object[] options) {
		String display ="";
		for(int i = 0; i<options.length; i++) {
			int choiceNumber = i+1;
			display += "\n"+choiceNumber+") "+options[i];
		}
		display += "\n\nPlease choose which family you'll be working for >>> ";
		return display;
	}
}
