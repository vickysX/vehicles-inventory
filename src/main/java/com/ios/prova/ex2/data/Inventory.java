package com.ios.prova.ex2.data;

import java.util.List;
import java.util.function.Predicate;

import com.ios.prova.ex2.vehicles.Sellable;


public class Inventory<T extends Sellable> {

    private List<T> items;
    private CSVItemsParser<T> csvParser;

    public Inventory(CSVItemsParser<T> csvParser) {
        this.csvParser = csvParser;
        this.items = this.csvParser.getItemsInFile();
    }

    public List<T> getAllItems() {
        return items;
    }

    public void addItem(T item) {
        if (!isItemInInventory(item)) {
            items.add(item);
            csvParser.writeItemToFile(item);
            System.out.println("Articolo inserito");
        } else {
            System.out.println("Articolo già presente nel nostro inventario");
        }  
    }

    private boolean isItemInInventory(T item) {
        return items.stream()
            .anyMatch(itemInInventory -> itemInInventory.equals(item));
    }

    public List<T> getBy(Predicate<T> filterBy) {
        return items.stream()
            .filter(filterBy).toList();
    }

}