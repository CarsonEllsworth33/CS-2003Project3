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
	public Car() {
		
	}
	public void Increment() {
		position++;
	}
	
	public void setSpeed(int i) {
		// TODO Auto-generated method stub
		this.speed = i;
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
