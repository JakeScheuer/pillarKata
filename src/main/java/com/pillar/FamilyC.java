package com.pillar;

public class FamilyC implements Payable{
	
	private int payOut;
	private int[] rates = new int[] {21, 15};
	
	@Override
	public int calculatePay(Shift shift) {
		int hoursBefore9 = 9 - shift.getStartTime();
		this.payOut += hoursBefore9 * rates[0]; 
		
		return this.payOut;
	}

}
