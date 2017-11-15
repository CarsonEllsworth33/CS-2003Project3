package com.ellsworth.Project3;

public class Car {
	private int speed;
	private double arrivalTime;
	private double departureTime;
	private int distanceDriven;
	//the car will advance 1 tile per second at 75 mph
	private int ftPerS = 100;
	// the car will advance 1 tile per 2 seconds at 40 mph
	private int conFtPerS = 50; 
	private int position;
	private boolean inConstruction = false;
	private Highway whereImDriving;
	
	public Car(int position, Highway HW, int arrivalTime) {
		this.arrivalTime = arrivalTime;
		this.position = position;
		this.whereImDriving = HW;
		this.setDistanceDriven(position);
	}
	
	public void Increment() {
		this.mergeCheck();
		if(this.inConstruction) {
			this.position = this.position + conFtPerS;
		}
		else {
			this.position = this.position + ftPerS;
		}
		
	}
	
	public String toString() {
		String s = " Pos: "+this.getPosition()+" AT: "+this.getArrivalTime() + " C_Zone; " + this.inConstruction;
		return s;
	}
	
	/**
	 * function used to transfer over the car to the construction queue
	 */
	public void mergeCheck() {
		if(this.inConstructHW()) {
			if(this.getPosition()>=780 && this.inConstruction == false) {//ready to be in the construction zone
				whereImDriving.getConstructionHW().enqueue(this);
				whereImDriving.getRegularHW().dequeue();
				this.inConstruction = true;
			}
		}	
	}
	

	public boolean inConstructHW() {
		return whereImDriving.getUnderConstruction();
	}
	
	public void setSpeed(int i) {
		// TODO Auto-generated method stub
		this.speed = i;
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

	public int getDistanceDriven() {
		return distanceDriven;
	}

	public void setDistanceDriven(int distanceDriven) {
		this.distanceDriven = distanceDriven;
	}
	
}
