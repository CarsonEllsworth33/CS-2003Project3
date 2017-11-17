package com.ellsworth.Project3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class Simulation {
	private int CarID = 1;
	private final double CARS_PER_MIN = .07;
	private List<Car> averageTlist = new LinkedList<Car>();
	private final int CARS_TO_ENTER = 2000;
	private int carCounter = 1;// at t = 0 one car is on the Highway

	/**
	 * manages the simulation and outputs data to a file
	 * 
	 * @param minutes
	 *            starting time of the sim in minutes
	 * @param seconds
	 *            starting time of the sim in seconds
	 * @param Highway
	 *            the desired HW to run
	 */
	public void clock(int minutes, int seconds, Highway HW) {
		HW.getHighway().enqueue(new Car(CarID, 0, HW, seconds / 60.0));
		System.out.println("runningSim");
		while (carCounter <= CARS_TO_ENTER) {
			seconds++;
			if ((seconds % ((int) (60 / CARS_PER_MIN))) == 0 && !HW.getHighway().isFull()) {
				CarID++;
				carCounter++;
				HW.getHighway().enqueue(new Car(CarID, 0, HW, seconds / 60.0));
			}
				HW.carsInQueue(HW.getHighway(), seconds / 60.0, averageTlist);
		}
		File file = new File("AverageTimeToLeave" + HW.getHIGHWAY_ID() + "CZone" + HW.getCONSTRUCTION_LENGTH() + "CPM"
				+ this.CARS_PER_MIN +"CEnter"+this.CARS_TO_ENTER+ "HW.txt");
		try {
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			PrintWriter pw = new PrintWriter(file);
			String message = String.format("CZ size, %d, CPM, %.2f, CEnter, %d",HW.getCONSTRUCTION_LENGTH(),this.CARS_PER_MIN,this.CARS_TO_ENTER);
			pw.println(message);
			for (Car i : averageTlist) {
				message = String.format("Car ID, %d, Car TripT, %.2f, Car DT, %.2f, Car AT, %.2f", i.getID(),
						i.getAverageTime(), i.getDepartureTime(), i.getArrivalTime());
				pw.println(message);
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("\n\nCompleted");
		}
	}

	/**
	 * main function that initiates the Highways and Simulations
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Highway Construction = new Highway(true);
		Highway Regular = new Highway(false);
		Simulation simulation = new Simulation();
		
		if(!(simulation.CARS_PER_MIN > 60)) {
		simulation.clock(0, 0, Construction);
		simulation.clock(0, 0, Regular);
		}
		else {
			System.out.println("use values <= 60 for CARS_PER_MIN");
		}
	}

}
