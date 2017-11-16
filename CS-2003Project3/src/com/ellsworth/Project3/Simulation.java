package com.ellsworth.Project3;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Simulation {
	private static double minute;
	private static double seconds;
	
	
	public static void clock(int minutes, int seconds, Highway HW) {
//		File file = new File("AverageTimeToLeave"+HW.getHIGHWAY_ID()+"HW.txt");
//		try {
//			if(!file.exists()) {
//				try {
//					file.createNewFile();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			PrintWriter pw = new PrintWriter(file);
		setMinute(minutes);
		setSeconds(seconds);
		HW.getHighway().enqueue(new Car(0,HW,secondsToMinutes(seconds)));
		
		for(int i = 0; i <200000 ;i++) {
			seconds++;
			if(seconds%900 == 0 && !HW.getHighway().isFull()) {
				HW.getHighway().enqueue(new Car(0,HW,seconds));
				
			}
			if(!HW.getHighway().isEmpty()) {
				System.out.printf("car count: %d%n",HW.getHighway().size());
				HW.carsInQueue(HW.getHighway(), secondsToMinutes(seconds));
			}
//			String message = String.format("");
//		   	pw.println(message);
			
		}
		
//      pw.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally {
//			System.out.println("\n\nCompleted");
//		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Highway Construction = new Highway(true);
		clock(0,0,Construction);
		//Highway newHighway = new Highway(false);
		//clock(0,0,newHighway);
	}
	public static double secondsToMinutes(double seconds) {
		minute = seconds/60.0;
		return getMinute();
	}
	public static double getMinute() {
		return minute;
	}
	private static void setMinute(int timeInMinutes) {
		minute = timeInMinutes;
	}
	public double getSeconds() {
		return seconds;
	}
	private static void setSeconds(int timeInSeconds) {
		seconds = timeInSeconds;
	}
	
}
