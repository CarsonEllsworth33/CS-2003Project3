package com.ellsworth.Project3;

import java.util.List;

public class Car {
	private double speed;
	private double arrivalTime;
	private double departureTime;
	private double averageTime;
	// the car will advance 1 tile per second at 75 mph
	private int ftPerS = 110;
	// the car will advance 1 tile per 2 seconds at 40 mph
	private int conFtPerS = 59;
	private double position;
	private boolean inConstruction = false;
	private Highway whereImDriving;
	private final double HALF_FULL = 50.0;
	private final double THREEFOURTHS_FULL = 75.0;
	private final double NINETENTHS_FULL = 90.0;
	private final int ID;

	/**
	 * 
	 * @param position
	 * @param HW
	 *            - this determines which of the two highways the car is on
	 * @param arrivalTime
	 */
	public Car(int ID, int position, Highway HW, double arrivalTime) {
		this.ID = ID;
		this.arrivalTime = arrivalTime;
		this.position = position;
		this.whereImDriving = HW;
	}

	/**
	 * @return String that shows the car position, arrival time and if it is in
	 *         construction
	 */
	public String toString() {
		String s = String.format("ID: %d Pos: %.2f AT: %.2f CS: %.2f C_Zone: %s", this.ID, this.getPosition(),
				this.getArrivalTime(), this.getSpeed(), this.inConstruction);
		return s;
	}

	/**
	 * returns the arrival time in minutes of the Car Object as a double when
	 * entering the highway
	 * 
	 * @return double arrivalTime
	 */
	public double getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * returns the average time in minutes of the Car Object as a double
	 * 
	 * @return double averageTime
	 */
	public double getAverageTime() {
		return averageTime;
	}

	/**
	 * returns the departure time in minutes of the Car Object as a double when
	 * leaving the highway
	 * 
	 * @return double departureTime
	 */
	public double getDepartureTime() {
		return departureTime;
	}

	/**
	 * returns the position in ft of the Car Object on the Highway
	 * 
	 * @return double position
	 */
	public double getPosition() {
		return position;
	}

	/**
	 * returns the ID of the car for easy tracking
	 * 
	 * @return int ID
	 */
	public int getID() {
		return this.ID;
	}

	/**
	 * increments the cars position on the Highway based on the cars speed logging
	 * it to the List manager to record the departure time it will eventually reach
	 * 
	 * @param double
	 *            Time in Seconds
	 * @param List<Car>
	 *            the current manager of the Car records
	 */
	public void Increment(double departTime, List<Car> L) {
		if (!whereImDriving.getHighway().isEmpty()) {
			this.enteringConstruction();
			this.position = this.getPosition() + this.CarSpeed();
			this.exitHW(departTime, L);
		}
	}

	private double CarSpeed() {
		if (this.inConstructHW()) {
			if (this.getPosition() > whereImDriving.getHIGHWAY_LENGTH() - whereImDriving.getCONSTRUCTION_LENGTH()) {
				this.setSpeed(conFtPerS);
			} else {
				this.setSpeed(ftPerS);
			}
		} else {
			this.setSpeed(ftPerS);
		}
		return this.getSpeed();
	}

	private void enteringConstruction() {
		if (this.inConstruction == false) {
			if (this.inConstructHW()) {
				if (this.getPosition() > whereImDriving.getHIGHWAY_LENGTH() - whereImDriving.getCONSTRUCTION_LENGTH()) {
					this.position = whereImDriving.getHIGHWAY_LENGTH() - whereImDriving.getCONSTRUCTION_LENGTH();
					// System.out.println("Entering Construction");
					this.inConstruction = true;
				}
			}
		}
	}

	private void exitHW(double departure, List<Car> L) {
		if (this.needToExitHW()) {
			this.departureTime = departure;
			this.setAverageTime(this.getDepartureTime() - this.getArrivalTime());
			L.add(this);
			this.position = 0;
			whereImDriving.getHighway().dequeue();
		}
	}

	private boolean needToExitHW() {
		if (this.getPosition() > whereImDriving.getHIGHWAY_LENGTH()) {
			return true;
		} else
			return false;
	}

	private boolean inConstructHW() {
		return whereImDriving.getUnderConstruction();
	}

	private double speedMod(double d) {
		if (d < 50.0) {
			return 1.0;
		} else if (d >= this.HALF_FULL && d < this.THREEFOURTHS_FULL) {
			return .75;
		} else if (d >= this.THREEFOURTHS_FULL && d < this.NINETENTHS_FULL) {
			return .50;
		} else {
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

	private void setAverageTime(double averageTime) {
		this.averageTime = averageTime;
	}
}
