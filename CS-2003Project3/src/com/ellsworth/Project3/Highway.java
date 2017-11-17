package com.ellsworth.Project3;

import java.util.List;

import com.ellsworth.ArrayQueue.ArrayQueue;

public class Highway {
	private ArrayQueue constructionHW;// part of highway under construction
	private ArrayQueue regularHW;// part of highway not under construction
	// 1040 represents the number of cars(at which each car would occupy 100ft)
	// that would fit in a 20 mile Highway
	private final int HIGHWAY_SIZE = 1056;
	private final int HIGHWAY_LENGTH = 105600;
	// 260 represents the number of cars(at which each car would occupy 100ft)
	// that would fit in a 5 mile Highway
	private final int CONSTRUCTION_LENGTH;
	private final boolean underConstruction;
	private final String HIGHWAY_ID;
	private final double SAFE_DIST = 100.0;

	/**
	 * Constructs an Object of Type Highway that is either under construction or not
	 * 
	 * @param underConstruct
	 */
	public Highway(boolean underConstruct) {
		this.underConstruction = underConstruct;
		if (underConstruction == true) {
			CONSTRUCTION_LENGTH = 26400;
			HIGHWAY_ID = "ConstHW";
			constructionHW = new ArrayQueue(HIGHWAY_SIZE);
		} else {
			CONSTRUCTION_LENGTH = 0;
			HIGHWAY_ID = "RegHW";
			regularHW = new ArrayQueue(HIGHWAY_SIZE);
		}
	}

	/**
	 * gets each of the cars in the queue and determines if incrementing should
	 * occur
	 * 
	 * @param the
	 *            queue defining the Highway
	 * @param seconds
	 * @param L
	 *            car managing list to hold car information records
	 */
	public void carsInQueue(ArrayQueue A, double departTime, List<Car> L) {
		for (int i = A.getBack(); i >= A.getFront(); i--) {
			if (A.peekAt(i) instanceof Car) {
				if (A.getBack() == A.getFront()) {
					A.peekAt(i).Increment(departTime, L);
				}
				if (A.inFront(A.peekAt(i))) {
					A.peekAt(i).Increment(departTime, L);
				} else if (this.safeHighwayDriving(A, i)) {
					A.peekAt(i).Increment(departTime, L);
				}

			}
		}
	}

	/**
	 * this determines the Highway that a car is on or a simulation is running
	 * 
	 * @return ArrayQueue Highway
	 */
	protected ArrayQueue getHighway() {
		if (this.getUnderConstruction()) {
			return constructionHW;
		} else {
			return regularHW;
		}
	}

	/**
	 * returns the classification of the highway
	 * 
	 * @return String Highway name
	 */
	public String getHIGHWAY_ID() {
		return HIGHWAY_ID;
	}

	/**
	 * returns the boolean state of construction on the Highway
	 * 
	 * @return boolean underConstruction
	 */
	public boolean getUnderConstruction() {
		return underConstruction;
	}

	/**
	 * returns the highway construction length
	 * 
	 * @return int construction length
	 */
	public int getCONSTRUCTION_LENGTH() {
		return CONSTRUCTION_LENGTH;
	}

	/**
	 * returns the highway length
	 * 
	 * @return int highway length
	 */
	public int getHIGHWAY_LENGTH() {
		return HIGHWAY_LENGTH;
	}

	private boolean safeHighwayDriving(ArrayQueue A, int i) {
		try {
			if (A.inFront(A.peekAt(i)))
				return true;
			Car frontCar = A.peekAt(i - 1);
			Car backCar = A.peekAt(i);
			double posDif;
			posDif = frontCar.getPosition() - backCar.getPosition();
			if (posDif < SAFE_DIST)
				return false;
			else
				return true;
		}

		catch (NullPointerException e) {

		} catch (ArrayIndexOutOfBoundsException I) {

		}

		return false;

	}
}
