/*
 * Author: Sagar Kalburgi
 * Purpose: Demonstrate Object oriented concepts using Java
 * Date: 08/24/2015
 * Reference: Head First Java by Kathy Sierra and Bert Bates, Pg 170-175
 */

package Demo;

import java.util.ArrayList;

/* Creating an abstract class 'Vehicle' that acts as a parent class for all vehicles */

abstract class Vehicle
{
	String model;
	abstract void move();
}

/* Creating an interface called Gear, since a class can extend only once class. Another reason to implement Gear as interface 
 is that not all vehicles have gear system as explained later */

interface Gear
{
	public ArrayList<Integer> gearBox=new ArrayList<Integer>();
	public abstract void gearSystem();	
}

/* Creating a class for Bike that inherits property and method from parent class 'Vehicle' */

class Bike extends Vehicle
{
	private int manufactureYear;

	public int getManufactureYear() {
		return manufactureYear;
	}

	public void setManufactureYear(int manufactureYear) {
		this.manufactureYear = manufactureYear;
	}

	@Override
	void move() {
		System.out.println("Bike moving at the speed of 5 mph");		
	}
}

/* Creating a class 'gearBike' for Bikes that inherit properties and methods from its parent classes and also have gear system */

class gearBike extends Bike implements Gear
{
	@Override
	public void gearSystem() {
		System.out.println("Implementing gear system for bikes with four gears: 1,2,3,4");
		
		/* Rest of the code to implement gear functionality */
	}
	
}

/* Creating a class 'Car' */

class Car extends Vehicle implements Gear
{
	private String registrationNumber;
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	@Override
	void move() {
		System.out.println("Car moving with a speed of 35 mph");
	}

	@Override
	public void gearSystem() {
		System.out.println("Implementing gear system for cars with 7 gears: 1,2,3,4, Parking, Neutral and Reverse");
		
		/* Rest of the code to implement gear functionality */
	}
}

public class VehicleDemo {
	public static void main(String[] args) {
		
		/* Creating objects of concrete classes created above */
		
		gearBike b=new gearBike();
		b.model="Roadmaster";
		b.setManufactureYear(2014);
		System.out.println("Bike model: "+b.model+"\nManufacture year of the bike: "+b.getManufactureYear());
		b.move();
		
		/* Using reference of 'gear' interface to refer to the object of the class 'gearBike' that implements it */
		
		Gear g=b;
		g.gearSystem();
		
		Car c=new Car();
		c.model="Tesla";
		c.setRegistrationNumber("AZ123");
		System.out.println("\nCar model: "+c.model+"\nRegistration number of the car: "+c.getRegistrationNumber());
		c.move();
		c.gearSystem();
	}
}


