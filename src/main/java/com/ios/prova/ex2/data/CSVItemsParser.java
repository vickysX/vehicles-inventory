package com.ios.prova.ex2.data;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.ios.prova.ex2.vehicles.Sellable;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.CSVReaderHeaderAwareBuilder;
import com.opencsv.exceptions.CsvException;


public abstract class CSVItemsParser<T extends Sellable> {

    protected String fileName;
    protected List<String[]> records;

    public CSVItemsParser(String fileName) {
        this.fileName = fileName;
        this.records = getRecords();
    }

    private List<String[]> getRecords() {
        try (FileReader fileReader = new FileReader(fileName);
            CSVReaderHeaderAware reader = 
                new CSVReaderHeaderAwareBuilder(fileReader).build()
        ) {
            records = reader.readAll();
        } catch (IOException | CsvException exception) {
            System.err.println("Non abbiamo trovato la lista");
            System.exit(1);
        }       
        return records;
    }

    protected abstract void writeItemToFile(T item);

    protected abstract List<T> getItemsInFile();
    
}