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
	
	public void displayOptions(Object[] options) {
		out.println();
		for(int i = 0; i<options.length; i++) {
			int choiceNumber = i+1;
			out.println(choiceNumber+") "+options[i]);
		}
		out.print("\nPlease choose which family you'll be working for >>> ");
		out.flush();
	}
	public void displayStartTimePrompt() {
		out.println("What is your start time? >>> ");
		out.flush();
	}
	public void displayEndTimePrompt() {
		out.println("What is your end time? >>> ");
		out.flush();
	}
	public void displayResult() {
		out.println("Working for Family A from 5 to 11 will earn you $90");
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
	public void getEndTimeFromUserInput() {
		Integer endTime = null;
		while(endTime == null) {
			displayEndTimePrompt();
			endTime = in.nextInt();
		}
		this.shift.setEndTime(endTime);
	}
	public Shift getShift() {
		return this.shift;
	}
	public void displayGreeting() {
		out.println("Welcome Babysitter!");
		out.println("I can help you calculate your pay for one night of work!");
		out.println();
		out.println("Now tell me, which family will you be working for?");
	}
}
