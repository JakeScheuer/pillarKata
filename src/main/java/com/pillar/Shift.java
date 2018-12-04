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
		int totalTime = this.endTime - this.startTime;
		if(totalTime < 0) {
			totalTime = this.endTime + (12-this.startTime);
		}
		return totalTime;
	}
	
}
