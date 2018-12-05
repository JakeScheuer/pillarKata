package com.pillar;

public class PayCalculator {
	
	int payOut;
	
	public int calculatePay(Family family, Shift shift) {
		
		if(family.getFamilyName().equals("A")) {
			if(shift.endTime <= 11 && shift.endTime > 5) {
				this.payOut = family.getRate(0) * shift.calculateTotalHours(); 
			}
		}
		return payOut;
	}

}
