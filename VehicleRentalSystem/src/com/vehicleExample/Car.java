package com.vehicleExample;

import java.util.ArrayList;
import java.util.List;

public class Car extends Vehicle  {
	
	
	
	public Car() {
		this.setLicensePlate(licensePlate);
		this.setMake(make);
		this.setModel(model);
		this.setAvailable(true);
	}

	@Override
	public String toString() {
		return "Car [licensePlate=" + licensePlate + ", make=" + make + ", model=" + model + "]";
	}

}
