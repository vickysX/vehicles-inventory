package com.ios.prova.ex2.vehicles;


public class Moto extends Vehicle {

	public Moto() {
		super();
		this.wheels = 2;
	}

	public Moto(String brand, String model, double price, String id) {
		super(brand, model, price, id);
		this.wheels = 2;
	}

	@Override
	public void setPrice(double price) {
		this.price = 
			price >= 500 ? price : 500;
	}

}
