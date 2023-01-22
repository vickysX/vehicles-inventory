package com.ios.prova.ex2.data;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.ios.prova.ex2.vehicles.Vehicle;
import com.ios.prova.ex2.vehicles.VehicleFactory;


public class CSVVehiclesParser extends CSVItemsParser<Vehicle> {

    public CSVVehiclesParser(String fileName) {
        super(fileName);
    }

    @Override
    protected void writeItemToFile(Vehicle vehicle) {
        try (PrintWriter writer = 
            new PrintWriter(new FileOutputStream(fileName, true))
        ) {
            writer.println(vehicle);
        } catch (FileNotFoundException exception) {
            System.err.println("Impossibile aggiornare il file");
        } 
    }

    @Override
    protected List<Vehicle> getItemsInFile() {
        List<Vehicle> vehicles = new ArrayList<>();
        for (String[] record : records) {
            Vehicle vehicle = 
                VehicleFactory.makeVehicle(record);
            vehicles.add(vehicle);
        }
        return vehicles;
    }

}