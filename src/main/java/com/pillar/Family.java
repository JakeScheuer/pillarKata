package com.pillar;

public class Family {
	
	int[] rates = new int[] {15, 20};
	
	public int getRate(int timeFrame) {
		return rates[timeFrame];
	}

}
