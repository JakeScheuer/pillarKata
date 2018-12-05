package com.pillar;

public class PayCalculator {
	
	private int payOut;
	
	public int calculatePay(Family family, Shift shift) {
		
		if(family.getFamilyName().equals("A")) {
			int hoursBefore11 = 11 - shift.getStartTime();
			this.payOut += hoursBefore11 * family.getRate(0); 
			
			if(shift.getEndTime() == 12 || shift.getEndTime() <= 4) {
				int hoursAfter11 = shift.calculateTotalHours() - hoursBefore11;
				this.payOut += hoursAfter11 * family.getRate(1);
			}
		}
		if(family.getFamilyName().equals("B")) {
			int hoursBetween10And12 = shift.getEndTime() - 10;
			int hoursBefore10 = 10 - shift.getStartTime();
			this.payOut += hoursBefore10 * family.getRate(2);
			
			if(shift.getEndTime() > 10) {
				this.payOut += hoursBetween10And12 * family.getRate(3);
			}
		}
		return payOut;
	}
	
	public void resetPayOut() {
		this.payOut = 0;
	}
}
