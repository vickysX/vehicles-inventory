package com.ios.prova.ex2.ui;

import java.util.Scanner;

import com.ios.prova.ex2.data.Inventory;
import com.ios.prova.ex2.vehicles.Sellable;


public abstract class Launcher<T extends Sellable> {
    
    protected Inventory<T> inventory;
    protected Scanner scanner;

    public Launcher(Inventory<T> inventory) {
        this.inventory = inventory;
        this.scanner = new Scanner(System.in);
    }

    protected void searchByPrice() {
        System.out.println("Inserisci un prezzo");
        double priceInput = scanner.nextDouble();
        inventory.getBy(item -> item.getPrice() == priceInput)
            .forEach(System.out::println);
    }

    protected void searchById() {
        System.out.println("Inserisci una targa/codice identificativo");
        String idInput = scanner.next();
        System.out.println(
            inventory.getBy(item -> item
                .getId().equalsIgnoreCase(idInput)).get(0)
        );
    }

    public abstract void displayOptions();

    public abstract void executeOptions();

}
