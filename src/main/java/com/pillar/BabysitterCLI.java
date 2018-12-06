package com.pillar;

public class BabysitterCLI {
	
	private FamilyA familyA;
	private FamilyB familyB;
	private FamilyC familyC;
	private Menu menu;
	private Shift shift;
	private Payable[] families;

	public BabysitterCLI(Menu menu) {
		this.menu = menu;
		this.familyA = new FamilyA();
		this.familyB = new FamilyB();
		this.familyC = new FamilyC();
		this.shift = new Shift();
		this.families = new Payable[] {this.familyA, this.familyB, this.familyC};
	}
	
	public void run() {
		while(true) {
//			menu.displayGreeting();
			menu.getChoiceFromOptions();
//			menu.getStartTimeFromUserInput();
//			menu.getEndTimeFromUserInput();
//			menu.displayResult();
			break;
		}
	}
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		BabysitterCLI cli = new BabysitterCLI(menu);
		cli.run();
	}

}
