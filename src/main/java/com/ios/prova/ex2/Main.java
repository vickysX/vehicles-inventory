package com.ios.prova.ex2;

import com.ios.prova.ex2.data.CSVVehiclesParser;
import com.ios.prova.ex2.data.Inventory;
import com.ios.prova.ex2.ui.VehiclesLauncher;
import com.ios.prova.ex2.vehicles.Vehicle;


public class Main {

    public static void main(String[] args) {
        CSVVehiclesParser csvParser = 
            new CSVVehiclesParser("src/main/resources/vehicles.csv");
        Inventory<Vehicle> vehiclesInventory = new Inventory<Vehicle>(csvParser);
        VehiclesLauncher launcher = new VehiclesLauncher(vehiclesInventory);
        while (true) {
            launcher.displayOptions();
            launcher.executeOptions();
        }
    }
    
}
