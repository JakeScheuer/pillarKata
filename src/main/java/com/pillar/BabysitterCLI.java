package com.pillar;

public class BabysitterCLI {
	
	private Menu menu;
	private Shift shift;
	private Payable family;

	public BabysitterCLI(Menu menu) {
		this.menu = menu;
		this.shift = new Shift();
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
		BabysitterCLI cli = new BabysitterCLI(menu);
		cli.run();
	}
}
