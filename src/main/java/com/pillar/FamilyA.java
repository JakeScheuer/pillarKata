package com.pillar;

public class FamilyA implements Payable{
	
	private int payOut;
	private int[] rates = new int[] {15, 20};

	@Override
	public int calculatePay(Shift shift) {
		int hoursBefore11 = 11 - shift.getStartTime();
		this.payOut += hoursBefore11 * rates[0]; 
		
		if(shift.getEndTime() == 12 || shift.getEndTime() <= 4) {
			int hoursAfter11 = shift.calculateTotalHours() - hoursBefore11;
			this.payOut += hoursAfter11 * rates[1];
		}
		return this.payOut;
	}
}
