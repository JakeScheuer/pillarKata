package com.pillar;

public class FamilyB implements Payable{
	private int payOut;
	private int[] rates = new int[] {12, 8, 16};
	
	@Override
	public int calculatePay(Shift shift) {
		int hoursBetween10And12 = shift.getEndTime() - 10;
		int hoursBefore10 = 10 - shift.getStartTime();
		int hoursAfter12 = shift.getEndTime();
		if(shift.getEndTime() < 10 && shift.getEndTime() > 5) {
			hoursBefore10 = shift.calculateTotalHours();
		}
		this.payOut += hoursBefore10 * rates[0];
		
		if(shift.getEndTime() > 10) {
			this.payOut += hoursBetween10And12 * rates[1];
		}
		if(shift.getEndTime() <= 4) {
			this.payOut += hoursAfter12 * rates[2];
			hoursBetween10And12 = shift.calculateTotalHours()-hoursAfter12-hoursBefore10;
			this.payOut += hoursBetween10And12 * rates[1];
		}
	return payOut;
	}
}
