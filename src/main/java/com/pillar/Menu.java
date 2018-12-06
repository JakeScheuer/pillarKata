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
			String choice = in.nextLine();
			try {
				int selectedOption =Integer.valueOf(choice);
				switch(selectedOption) {
				case 1: family = new FamilyA();
				break;
				case 2: family = new FamilyB();
				break;
				case 3: family = new FamilyC();
				break;
				}
			} catch(NumberFormatException e) {
				}
			if(family == null) {
				out.println("\n*** "+choice+" is not a valid option ***\n");
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
			String userInput = in.nextLine();
			try {
				int startingAt = Integer.valueOf(userInput);
				if(startingAt >= 5 && startingAt < 12) {
					startTime = startingAt;
				}
			} catch(NumberFormatException e) {
				}
			if(startTime == 0) {
				out.println("\n*** "+userInput+" is not a valid option ***\n");
			}
		} return startTime;
	}
	public void displayEndTimePrompt() {
		out.println("What is your end time? >>> ");
		out.flush();
	}
	public int getEndTimeFromUserInput(int startTime) {
		int endTime = 0;
		while(endTime == 0) {
			displayEndTimePrompt();
			String userInput = in.nextLine();
			try {
				int endingAt = Integer.valueOf(userInput);
				if((endingAt > startTime && endingAt <=12) || (endingAt > 0 && endingAt <= 4)) {
					endTime = endingAt;
				}
			} catch(NumberFormatException e) {
				}
			if(endTime == 0) {
				out.println("\n*** "+userInput+" is not a valid option ***\n");
			}
		}
		return endTime;
	}
	public void displayResult(Payable family, Shift shift) {
		out.print("Working for ");
		out.print(family.getClass().getSimpleName());
		out.print(" from "+shift.getStartTime()+" to ");
		out.println(shift.getEndTime()+" will earn you $"+family.calculatePay(shift));
		out.flush();
	}
	public void displayEndingOptions() {
		out.println("Would you like to do another calculation? (Y/N) >>> ");
		out.flush();
	}
}
