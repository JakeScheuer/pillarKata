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
	public String displayStartTimePrompt() {
		String display = "What is your start time? >>> ";
		return display;
	}
	public String displayEndTimePrompt() {
		String display = "What is your end time? >>> ";
		return display;
	}
}
