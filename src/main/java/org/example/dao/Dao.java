package org.example.dao;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.*;
import java.util.List;

public class Dao<T> {

    private static final String PLANTILLA_RUTA = "dataset/{}.csv";

    private final CsvToBean<T> lector;
    private final StatefulBeanToCsv<T> escritor;

    public Dao(Class<T> clase) throws IOException {

        var rutaDataset = PLANTILLA_RUTA.replace("{}", clase.getSimpleName().toLowerCase());

        lector = new CsvToBeanBuilder<T>(new FileReader(rutaDataset))
                .withType(clase)
                .build();

        escritor = new StatefulBeanToCsvBuilder<T>(new FileWriter(rutaDataset, true))
                .build();
    }

    public List<T> getTodos() {
        return lector.parse();
    }
}
