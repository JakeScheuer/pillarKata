package com.pillar;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class Menu {

	private PrintWriter out;
	private Scanner in;
	
	public Menu(InputStream input, OutputStream output) {
		this.in = new Scanner(input);
		this.out = new PrintWriter(output);
	}
	public void displayGreeting() {
		out.println("Welcome Babysitter!");
		out.println("I can help you calculate your pay for one night of work!");
		out.println();
		out.println("Now tell me, which family will you be working for?");
		out.flush();
	}
	public void displayOptions() {
		out.println();
		out.println("1) Family A");
		out.println("2) Family B");
		out.println("3) Family C");
		out.print("\nPlease choose which family you'll be working for >>> ");
		out.flush();
	}
	public Payable getChoiceFromOptions() {
		Payable family = null;
		while(family == null) {
			displayOptions();
			int choice = in.nextInt();
			switch(choice) {
				case 1: family = new FamilyA();
				break;
				case 2: family = new FamilyB();
				break;
				case 3: family = new FamilyC();
				break;
			}
		}
		return family;
	}
	public void displayStartTimePrompt() {
		out.println("What is your start time? >>> ");
		out.flush();
	}
	public int getStartTimeFromUserInput() {
		int startTime = 0;
		while(startTime == 0) {
			displayStartTimePrompt();
			startTime = in.nextInt();
		}
		return startTime;
	}
	public void displayEndTimePrompt() {
		out.println("What is your end time? >>> ");
		out.flush();
	}
	public int getEndTimeFromUserInput() {
		int endTime = 0;
		while(endTime == 0) {
			displayEndTimePrompt();
			endTime = in.nextInt();
		}
		return endTime;
	}
//	public void displayResult() {
//		out.println("Working for Family A from 5 to 11 will earn you $90");
//		out.flush();
//	}
}
