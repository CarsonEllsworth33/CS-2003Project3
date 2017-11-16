package com.ellsworth.Project3;

public class Car {
	private double speed;
	private double arrivalTime;
	private double departureTime;
	private int distanceDriven;
	//the car will advance 1 tile per second at 75 mph
	private int ftPerS = 110;
	// the car will advance 1 tile per 2 seconds at 40 mph
	private int conFtPerS = 59; 
	private double position;
	private boolean inConstruction = false;
	private Highway whereImDriving;
	
	/**
	 * 
	 * @param position
	 * @param HW - this determines which of the two highways the car is on
	 * @param arrivalTime
	 */
	public Car(int position, Highway HW, int arrivalTime) {
		this.arrivalTime = arrivalTime;
		this.position = position;
		this.whereImDriving = HW;
		this.setDistanceDriven(position);
	}
	
	public void Increment() {
		this.position = this.getPosition() + this.CarSpeed();
	}
	
	public double CarSpeed() {
		if(this.inConstructHW()) {
			if(this.getPosition() > whereImDriving.getConstructionHW().getMAX_QUEUE()-260) {
				this.setSpeed(conFtPerS);
			}
			else {
				this.setSpeed(ftPerS);
			}		
		}
		return speed;
	}
	
	public String toString() {
		String s = " Pos: "+this.getPosition()+" AT: "+this.getArrivalTime() + " C_Zone; " + this.inConstruction;
		return s;
	}
	
	public boolean inConstructHW() {
		return whereImDriving.getUnderConstruction();
	}
	
	public double speedMod(double d) {
		if(d<=49.9) {
			return 1.0;
		}
		else if(d >= 50.0 && d <=74.9) {
			return .75;
		}
		else if(d >= 75.0 && d<=89.9) {
			return .50;
		}
		else {
			return .25;
		}
	}
	
	public void setSpeed(double i) {
		// TODO Auto-generated method stub
		double speedMod = this.speedMod(whereImDriving.getConstructionHW().percentFull()); 
		this.speed = i * speedMod;	
	}
	
	public double getSpeed() {
		return speed;
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


	public double getPosition() {
		return position;
	}

	public int getDistanceDriven() {
		return distanceDriven;
	}

	public void setDistanceDriven(int distanceDriven) {
		this.distanceDriven = distanceDriven;
	}
	
}
