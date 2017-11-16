package com.ellsworth.Project3;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Simulation {
	private double minute;
	private double seconds;
	private int CarID = 1;
	private final int CARS_PER_MIN = 5;
	
	public void clock(int minutes, int seconds, Highway HW) {
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
		HW.getHighway().enqueue(new Car(CarID,0,HW,seconds/60.0));
		
		for(int i = 0; i <200000 ;i++) {
			seconds++;
			if(seconds%(60/CARS_PER_MIN) == 0 && !HW.getHighway().isFull()) {
				CarID++;
				HW.getHighway().enqueue(new Car(CarID,0,HW,seconds/60.0));
				
			}
			if(!HW.getHighway().isEmpty()) {
				System.out.printf("car count: %d%n",HW.getHighway().size());
				HW.carsInQueue(HW.getHighway(), seconds/60.0);
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
		Highway Regular = new Highway(false);
		Simulation simulation = new Simulation();
		
		simulation.clock(0, 0, Construction);
		//simulation.clock(0, 0, Regular);
	}
	public double secondsToMinutes() {
		return seconds/60;
	}
	
	public double getMinute() {
		return minute;
	}
	private void setMinute(int timeInMinutes) {
		minute = timeInMinutes;
	}
	public double getSeconds() {
		return seconds;
	}
	private void setSeconds(int timeInSeconds) {
		seconds = timeInSeconds;
	}
	
}
