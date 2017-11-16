package com.ellsworth.Project3;
import com.ellsworth.ArrayQueue.ArrayQueue;
public class Highway {
	private  ArrayQueue constructionHW;//part of highway under construction
	private  ArrayQueue regularHW;// part of highway not under construction
	//1040 represents the number of cars(at which each car would occupy 100ft)
	//that would fit in a 20 mile Highway
	private final int HIGHWAY_SIZE = 1050;
	//260 represents the number of cars(at which each car would occupy 100ft)
	//that would fit in a 5 mile Highway 
	private final int CONSTRUCTION_ZONE = 260;
	private final int SPEED_LIMIT = 75;
	private final int CONSTRUCTION_SL = 40;
	private final boolean underConstruction;
	
	public Highway(boolean underConstruct) {
		this.underConstruction = underConstruct;
		if(underConstruction == true) {
			constructionHW = new ArrayQueue(CONSTRUCTION_ZONE,"Construction: ");
			regularHW = new ArrayQueue(HIGHWAY_SIZE - CONSTRUCTION_ZONE,"Regular: ");	
		}
		else {
			constructionHW = new ArrayQueue(0,"Construction: ");
			regularHW = new ArrayQueue(HIGHWAY_SIZE,"Regular: ");
		}	
	}
	
	public int carsInQueue(ArrayQueue A) {
		int carCount = 0;
		for(int i = 0; i < A.size(); i++) {
			if(A.peekAt(i) instanceof Car) { 
				carCount++;
				A.peekAt(i).Increment();
				A.peekAt(i).toString();
			}
		}
		return carCount;
	}
	
	public String toString() {
		String s = this.getRegularHW().toString() + "\n" + this.getConstructionHW().toString();
		return s;
	}
	
	public ArrayQueue getConstructionHW() {
		return constructionHW;
	}
	
	public ArrayQueue getRegularHW() {
		return regularHW;
	}
	
	public int getConstSpeedLimit() {
		return CONSTRUCTION_SL;
	}
	
	public int getSpeedLimit() {
		return SPEED_LIMIT;
	}
	
	public boolean getUnderConstruction() {
		return underConstruction;
	}
}
