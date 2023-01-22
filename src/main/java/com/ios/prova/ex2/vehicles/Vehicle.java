package com.ios.prova.ex2.vehicles;


public abstract class Vehicle implements Sellable {
	
	protected String brand;
	protected String model;
	protected double price;
	protected String id;
	protected int wheels;

	public Vehicle() {

	}

	public Vehicle(String brand, String model, double price, String id) {
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	protected void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	protected void setModel(String model) {
		this.model = model;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public String getId() {
		return id;
	}

	protected void setId(String id) {
		this.id = id;
	}
		
	public int getWheels() {
		return wheels;
	}
	
	@Override
	public boolean equals(Object vehicleObj) {
		if (!(vehicleObj instanceof Vehicle))
			return false;
		Vehicle vehicle = (Vehicle) vehicleObj;
		return this.getBrand().equalsIgnoreCase(vehicle.getBrand()) && 
				this.getModel().equalsIgnoreCase(vehicle.getModel()) && 
				this.getPrice() == vehicle.getPrice() &&
				this.getId().equalsIgnoreCase(vehicle.getId()) && 
				this.getWheels() == vehicle.getWheels();
	}
		
	@Override
	public String toString() {
		return brand + "," + model + "," + price + "," + id + "," + wheels;
	}

	@Override
	public abstract void setPrice(double price);
	
}
