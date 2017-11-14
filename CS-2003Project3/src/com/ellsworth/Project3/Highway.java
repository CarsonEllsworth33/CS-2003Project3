package com.ellsworth.Project3;
import com.ellsworth.ArrayQueue.ArrayQueue;
public class Highway {
	private  ArrayQueue constructionHW;//part of highway under construction
	private  ArrayQueue regularHW;// part of highway not under construction
	//1040 represents the number of cars(at which each car would occupy 100ft)
	//that would fit in a 20 mile Highway
	private final int HIGHWAY_SIZE = 1040;
	//260 represents the number of cars(at which each car would occupy 100ft)
	//that would fit in a 5 mile Highway 
	private final int CONSTRUCTION_ZONE = 260;
	private final int SPEED_LIMIT = 75;
	private final int CONSTRUCTION_SL = 40;
	
	public Highway(boolean underConstruction) {
		if(underConstruction == true) {
			constructionHW = new ArrayQueue(CONSTRUCTION_ZONE);
			regularHW = new ArrayQueue(HIGHWAY_SIZE - CONSTRUCTION_ZONE);
		
		}
		else {
			constructionHW = new ArrayQueue(0);
			regularHW = new ArrayQueue(HIGHWAY_SIZE);
		}
		
	}
	public boolean endOfHW() {
		if(this.CONSTRUCTION_ZONE != 0) {
			
		}
		return false;
	}
	public int checkEndofHW(Car C) {
		//if this is true then there is a car at the end of the Highway
		if(this.regularHW.getBack()==this.regularHW.getMAX_QUEUE()&&this.regularHW.peek().equals(C)) {
			
		}
		return 0;
	}
	public ArrayQueue getContructionHW() {
		return constructionHW;
	}
	public ArrayQueue getRegularHW() {
		return regularHW;
	}
	
	public static void main(String...strings) {
		
	}
	public int getConstSpeedLimit() {
		return CONSTRUCTION_SL;
	}
	public int getSpeedLimit() {
		return SPEED_LIMIT;
	}
	
}
