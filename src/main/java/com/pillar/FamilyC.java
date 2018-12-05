package com.pillar;

public class FamilyC implements Payable{
	
	private int payOut;
	private int[] rates = new int[] {21, 15};
	
	@Override
	public int calculatePay(Shift shift) {
		int hoursBefore9 = 9 - shift.getStartTime();
		int hoursAfter9 = shift.getEndTime() + (12-shift.getStartTime());
		if(shift.getStartTime() < 9) {
			this.payOut += hoursBefore9 * rates[0]; 
		}
		if(shift.getEndTime() > 5) {
			hoursAfter9 = shift.getEndTime() - 9;
		}
		this.payOut += hoursAfter9 * rates[1];
		
		return this.payOut;
	}

}
