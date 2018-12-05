package com.pillar;

public class Family {
	private String familyName;
	private int[] rates = new int[] {15, 20, 12, 8};
	
	public int getRate(int timeFrame) {
		return rates[timeFrame];
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	

}
