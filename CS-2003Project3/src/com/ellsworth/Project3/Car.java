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
	private final double HALF_FULL = 50.0;
	private final double THREEFOURTHS_FULL = 75.0;
	private final double NINETENTHS_FULL = 90.0;
	/**
	 * 
	 * @param position
	 * @param HW - this determines which of the two highways the car is on
	 * @param arrivalTime
	 */
	public Car(int position, Highway HW, double arrivalTime) {
		this.arrivalTime = arrivalTime;
		this.position = position;
		this.whereImDriving = HW;
		this.setDistanceDriven(position);
	}
	
	public void Increment(double departTime) {
		if(!whereImDriving.getHighway().isEmpty()) {
			this.enteringConstruction();
			this.position = this.getPosition() + this.CarSpeed();
			this.exitHW(departTime);
		}
	}
	
	public double CarSpeed() {
		if(this.inConstructHW()) {
			if(this.getPosition() > whereImDriving.getHIGHWAY_LENGTH()-whereImDriving.getCONSTRUCTION_LENGTH()) {
				this.setSpeed(conFtPerS);
			}
			else {
				this.setSpeed(ftPerS);
			}		
		}
		else {
			this.setSpeed(ftPerS);
		}
		return this.getSpeed();
	}
	
	public void enteringConstruction() {
		if(this.inConstruction == false) {
			if(this.inConstructHW()) {
				if(this.getPosition() > whereImDriving.getHIGHWAY_LENGTH()-whereImDriving.getCONSTRUCTION_LENGTH()) {
					this.position = whereImDriving.getHIGHWAY_LENGTH()-whereImDriving.getCONSTRUCTION_LENGTH();
					System.out.println("Entering Construction");
					this.inConstruction = true;
				}
			}
		}	
	}
	
	/**
	 * handles the method calls to determine if the car needs to leave the Highway
	 */
	public void exitHW(double departure) {
		if(this.needToExitHW()) {
			this.setDepartureTime(departure);
			System.out.println("DepartureTime: "+this.getDepartureTime());
			System.out.println("Exiting Highway\n");
			whereImDriving.getHighway().dequeue();
		}
		else System.out.println("Keep Driving\n");
	}
	
	private boolean needToExitHW() {
		if(this.getPosition() > whereImDriving.getHIGHWAY_LENGTH()) {
			//then needs to exit highway and must be at the front of the HW
			return true;
		}
		else return false;
	}
	
	/**
	 * @return String that shows the car position, arrival time and if it is in construction
	 */
	public String toString() {
		String s = String.format("Pos: %.2f AT: %.2f CS: %.2f C_Zone: %s", this.getPosition(),this.getArrivalTime(),this.getSpeed(), this.inConstruction);
		return s;
	}
	
	public boolean inConstructHW() {
		return whereImDriving.getUnderConstruction();
	}
	/**
	 * this function modifies the speed of the car by the fullness of the highway
	 * @param double fullness of Highway
	 * @return double speed modifier
	 */
	public double speedMod(double d) {
		if(d<50.0) {
			return 1.0;
		}
		else if(d >= this.HALF_FULL && d < this.THREEFOURTHS_FULL) {
			return .75;
		}
		else if(d >= this.THREEFOURTHS_FULL && d < this.NINETENTHS_FULL) {
			return .50;
		}
		else {
			return .25;
		}
	}
	
	private void setSpeed(double i) {
		// TODO Auto-generated method stub
		double speedMod = this.speedMod(whereImDriving.getHighway().percentFull()); 
		this.speed = i * speedMod;	
	}
	
	private double getSpeed() {
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
