package com.ellsworth.Project3;


public class Simulation {
	private static int minute;
	private static int seconds;
	
	public static void clock(int minutes, int seconds, Highway HW) {
		setMinute(minutes);
		setSeconds(seconds);
		for(int i = 0; i < 30000;i++) {
			
			seconds++;
			if(HW.getRegularHW().isFull()) {
				HW.getConstructionHW().enqueue(HW.getRegularHW().dequeue());
			}
			
			HW.getRegularHW().enqueue(null);
			if(seconds == 60) {
				minute++;
				seconds = 0;
				HW.getRegularHW().enqueue(new Car(0,HW,i));
				
			}	
			
			//System.out.printf("min: %d sec: %d RHWbackPos: %d CHWbackPos: %d RHWfrontPos: %d CHWfrontPos: %d RHWcount: %d CHWcount: %d%n",minute,seconds,HW.getRegularHW().getBack(),HW.getConstructionHW().getBack(),HW.getRegularHW().getFront(),HW.getConstructionHW().getFront(),HW.getRegularHW().size(),HW.getConstructionHW().size());
			System.out.printf("RHWcar: %d CHWcar: %d%n",HW.carsInQueue(HW.getRegularHW()),HW.carsInQueue(HW.getConstructionHW()));
			System.out.printf("Car# %d pos: %d");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Highway Construction = new Highway(true);
		clock(0,0,Construction);
		Highway newHighway = new Highway(false);
		clock(0,0,newHighway);
	}
	
	public int getMinute() {
		return minute;
	}
	private static void setMinute(int timeInMinutes) {
		minute = timeInMinutes;
	}
	public int getSeconds() {
		return seconds;
	}
	private static void setSeconds(int timeInSeconds) {
		seconds = timeInSeconds;
	}
	
}
