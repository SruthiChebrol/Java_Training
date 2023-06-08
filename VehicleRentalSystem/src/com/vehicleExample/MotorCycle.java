package com.vehicleExample;

import java.util.ArrayList;
import java.util.List;

public class MotorCycle extends Vehicle {
	public void startEngine() {
		System.out.println("Starting the motorcycle engine.");
	}

	@Override
	public String toString() {
		return "MotorCycle [licensePlate=" + licensePlate + ", make=" + make + ", model=" + model + "]";
	}
	
}
