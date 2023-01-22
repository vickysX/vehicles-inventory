package com.ios.prova.ex2.vehicles;


public class Car extends Vehicle {

	public Car() {
		super();
		this.wheels = 4;
	}

	public Car(String brand, String model, double price, String id) {
		super(brand, model, price, id);
		this.wheels = 4;
	}

	@Override
	public void setPrice(double price) {
		this.price = 
			price >= 1500 ? price : 1500;
	}

}
