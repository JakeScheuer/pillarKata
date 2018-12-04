package com.pillar;

public class Shift {
	int startTime;
	int endTime;

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	
	public int calculateTotalHours() {
		return this.endTime - this.startTime;
	}
	
}
