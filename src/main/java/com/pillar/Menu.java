package com.pillar;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class Menu {

	private PrintWriter out;
	private Scanner in;
	private Object family;
	private Shift shift;
	
	public Menu(InputStream input, OutputStream output) {
		this.in = new Scanner(input);
		this.out = new PrintWriter(output);
		this.shift = new Shift();
	}
	
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
	public String displayResult() {
		String display = "Working for Family A from 5 to 11 will earn you $90";
		return display;
	}
	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while(choice == null) {
			displayOptions(options);
			choice = in.nextLine();
		}
		this.family = choice;
		int selection = Integer.valueOf(choice.toString())-1;
		return options[selection];
	}
	public void getStartTimeFromUserInput() {
		Integer startTime = null;
		while(startTime == null) {
			displayStartTimePrompt();
			startTime = in.nextInt();
		}
		this.shift.setStartTime(startTime);
	}
	public Shift getShift() {
		return this.shift;
	}
}
