package com.ellsworth.Project3;

import java.util.Random;

public class Simulation {
	private static int minute;
	private static int seconds;
	private final static int SIM_SPEED = 50;
	
	public static void clock(int minutes, int seconds, Highway HW) {
		setMinute(minutes);
		setSeconds(seconds);
		for(int i = 0; i < 30000;i++) {
			try {
				Thread.sleep(SIM_SPEED);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			seconds++;
			if(HW.getRegularHW().isFull()) {
				HW.getContructionHW().enqueue(HW.getRegularHW().dequeue());
			}
			HW.getRegularHW().enqueue(null);
			if(seconds == 60) {
				minute++;
				seconds = 0;
				HW.getRegularHW().enqueue(new Car());
			}	
			
			System.out.printf("min: %d sec: %d backPos: %d%n",minute,seconds,HW.getRegularHW().getBack());
			
			
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
