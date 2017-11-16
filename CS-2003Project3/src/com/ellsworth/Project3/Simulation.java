package com.ellsworth.Project3;


public class Simulation {
	private static int minute;
	private static int seconds;
	private static Car testCar;
	
	public static void clock(int minutes, int seconds, Highway HW) {
		setMinute(minutes);
		setSeconds(seconds);
		testCar = new Car(0, HW, 0);
		for(int i = 0; i < 10;i++) {
			try {
				Thread.sleep(750);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			seconds++;
			
			testCar.Increment();
			System.out.println(testCar.toString());
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
