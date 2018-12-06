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
		while(true) {
			menu.displayGreeting();
			this.family = menu.getChoiceFromOptions();
			this.shift.setStartTime(menu.getStartTimeFromUserInput());
			this.shift.setEndTime(menu.getEndTimeFromUserInput());
			menu.displayResult(this.family, this.shift);
			break;
		}
	}
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		BabysitterCLI cli = new BabysitterCLI(menu);
		cli.run();
	}

}
