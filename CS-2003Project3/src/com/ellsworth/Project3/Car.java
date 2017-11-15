package com.ellsworth.Project3;

public class Car {
	private int speed;
	private double arrivalTime;
	private double departureTime;
	//the car will advance 1 tile per second at 75 mph
	private int ftPerS = 100;
	// the car will advance 1 tile per 2 seconds at 40 mph
	private int conFtPerS = 50; 
	private int position;
	private Highway whereImDriving;
	
	public Car(int position, Highway HW) {
		this.position = position;
		this.whereImDriving = HW;
	}
	
	public void Increment() {
		position++;
	}
	
	public void setSpeed(int i) {
		// TODO Auto-generated method stub
		this.speed = i;
	}
	
	public void driveSpeed() {
		if(this.inConstruction()) {
			this.setSpeed(conFtPerS);
		}
		else {
			this.setSpeed(ftPerS);
		}
		
	
	}
	//not complete needs to take into count that after exiting that speed is out of scope
	public void driveHW(int speed) {
		if(speed%100 == 0) {
			this.Increment();
		}
		else speed = speed*2;
	}

	public boolean inConstruction() {
		return false;
	}


	public double getArrivalTime() {
		return arrivalTime;
	}


	public void setArrivalTime(double arrivalTime) {
		this.arrivalTime = arrivalTime;
	}


	public double getDepartureTime() {
		return departureTime;
	}


	public void setDepartureTime(double departureTime) {
		this.departureTime = departureTime;
	}


	public int getPosition() {
		return position;
	}
	
}
