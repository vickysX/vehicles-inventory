package com.ios.prova.ex2.ui;

import static com.ios.prova.ex2.vehicles.VehicleFactory.makeVehicle;

import com.ios.prova.ex2.data.Inventory;
import com.ios.prova.ex2.vehicles.Car;
import com.ios.prova.ex2.vehicles.Moto;
import com.ios.prova.ex2.vehicles.Vehicle;

import com.ios.prova.ex2.vehicles.VehicleType;


public class VehiclesLauncher extends Launcher<Vehicle> {

    public VehiclesLauncher(Inventory<Vehicle> vehiclesInventory) {
        super(vehiclesInventory);
    }

    @Override
    public void displayOptions() {
        System.out.println(
            "1 - auto\n" +
            "2 - moto\n" +
            "3 - cerca per targa\n" +
            "4 - cerca per prezzo\n" +
            "5 - aggiungi auto\n" +
            "6 - aggiungi moto\n" +
            "altri tasti - esci"
        );
    }

    @Override
    public void executeOptions() {
        try {
            String input = scanner.next();
            switch (input) {
            case "1":
                inventory.getBy(vehicle -> vehicle instanceof Car)
                    .forEach(System.out::println);
                break;
            case "2":
                inventory.getBy(vehicle -> vehicle instanceof Moto)
                    .forEach(System.out::println);
                break;
            case "3":
                searchById();
                break;
            case "4":
                searchByPrice();
                break;
            case "5":
                insertVehicle(VehicleType.CAR);
                break;
            case "6":
                insertVehicle(VehicleType.MOTO);
                break;
            default:
                System.exit(0);
            }
        } catch (NumberFormatException | IndexOutOfBoundsException exception) {
            System.err.println("Input scorretto");
            System.exit(1);
        }
        System.out.println("\n\n");
    }

    private void insertVehicle(VehicleType vehicleType) {
        System.out.println("Inserisci marca, modello, prezzo e targa" +
            " separati da una virgola");
        String input = scanner.next();
        String[] vehicleAttributes = input.split(",");
        inventory.addItem(makeVehicle(vehicleType, vehicleAttributes));
    }

}
