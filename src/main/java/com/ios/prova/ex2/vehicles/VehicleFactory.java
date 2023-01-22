package com.ios.prova.ex2.vehicles;


public class VehicleFactory {

    public VehicleFactory() {

    }

    public static Vehicle makeVehicle(VehicleType vehicleType, String[] vehicleAttributes) {
        Vehicle vehicle =
            vehicleType.equals(VehicleType.CAR) ?
                new Car() : new Moto();
        setAttributes(vehicle, vehicleAttributes);
        return vehicle;
    }

    public static Vehicle makeVehicle(String[] vehicleAttributes) {
        int wheels = Integer.parseInt(vehicleAttributes[4]);
        Vehicle vehicle = 
            wheels == 4 ? new Car() : new Moto();
        setAttributes(vehicle, vehicleAttributes);
        return vehicle;
    }

    private static void setAttributes(Vehicle vehicle, String[] vehicleAttributes) {
        vehicle.setBrand(vehicleAttributes[0]);
        vehicle.setModel(vehicleAttributes[1]);
        vehicle.setPrice(Double.parseDouble(vehicleAttributes[2]));
        vehicle.setId(vehicleAttributes[3]);
    }

}
