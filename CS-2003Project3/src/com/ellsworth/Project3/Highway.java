package com.ellsworth.Project3;
import com.ellsworth.ArrayQueue.ArrayQueue;
public class Highway {
	private  ArrayQueue constructionHW;//part of highway under construction
	private  ArrayQueue regularHW;// part of highway not under construction
	//1040 represents the number of cars(at which each car would occupy 100ft)
	//that would fit in a 20 mile Highway
	private final int HIGHWAY_SIZE = 1056;
	private final int HIGHWAY_LENGTH = 105600;
	//260 represents the number of cars(at which each car would occupy 100ft)
	//that would fit in a 5 mile Highway 
	private final int CONSTRUCTION_LENGTH;
	private final boolean underConstruction;
	private final String HIGHWAY_ID;
	
	public Highway(boolean underConstruct) {
		this.underConstruction = underConstruct;
		if(underConstruction == true) {
			CONSTRUCTION_LENGTH = 26400;
			HIGHWAY_ID = "ConstHW";
			constructionHW = new ArrayQueue(HIGHWAY_SIZE,"Construction: ");	
		}
		else {
			CONSTRUCTION_LENGTH = 0;
			HIGHWAY_ID = "RegHW";
			regularHW = new ArrayQueue(HIGHWAY_SIZE,"Regular: ");
		}	
	}
	
	public int carsInQueue(ArrayQueue A,double departTime) {
		int carCount = 0;
		for(int i = 1; i < A.size(); i++) {
			if(A.peekAt(i) instanceof Car) {
				if() {
					//System.out.println(i);
					//System.out.println(A.getBack());
					if((A.peekAt(i+1).getPosition() - A.peekAt(i).getPosition()) >= 100) {
						System.out.println((A.peekAt(i).getPosition() - A.peekAt(i+1).getPosition()));
						carCount++;
						A.peekAt(i).Increment(departTime);	
						//A.toString();
					}
				}
			}
		}
		return carCount;
	}
	
	public String toString() {
		String s = this.getHighway().toString() + "\n";
		return s;
	}
	
	public ArrayQueue getHighway() {
		if(this.getUnderConstruction()) {
			return constructionHW;
		}
		else {
			return regularHW;
		}
	}
	public String getHIGHWAY_ID() {
		return HIGHWAY_ID;
	}
	
	public boolean getUnderConstruction() {
		return underConstruction;
	}

	public int getCONSTRUCTION_LENGTH() {
		return CONSTRUCTION_LENGTH;
	}

	public int getHIGHWAY_LENGTH() {
		return HIGHWAY_LENGTH;
	}
}
