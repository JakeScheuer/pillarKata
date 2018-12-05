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
		return payOut;
	}
	
	public void resetPayOut() {
		this.payOut = 0;
	}
}
