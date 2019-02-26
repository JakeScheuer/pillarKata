package com.pillar;

import java.io.IOException;


import com.pillar.view.Menu;

public class BabysitterCLI {
	
	private Menu menu;
	private com.pillar.Shift shift;
	private com.pillar.Payable family;

	public BabysitterCLI(Menu menu) throws IOException {
		this.menu = menu;
		this.shift = new com.pillar.Shift();
	}
	public void run() {
		menu.displayGreeting();
		boolean running = true;
		while(running) {
			while(true) {
				this.family = menu.getChoiceFromOptions();
				this.shift.setStartTime(menu.getStartTimeFromUserInput());
				this.shift.setEndTime(menu.getEndTimeFromUserInput(this.shift.getStartTime()));
				menu.displayResult(this.family, this.shift);
				if(!menu.getToRun()) {
					menu.displayGoodbyeMessage();
					running = false;
					break;
					}
				break;
			}
		}
	}
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		BabysitterCLI cli;
		try {
			cli = new BabysitterCLI(menu);
			cli.run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
