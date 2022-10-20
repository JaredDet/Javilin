package org.example.dao;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public abstract class Dao<T, ID> {

    private static final String PLANTILLA_RUTA = "dataset/{}.csv";
    private final String rutaDataset;

    protected final CsvToBean<T> lector;
    protected final StatefulBeanToCsv<T> escritor;

    public Dao(Class<T> clase) throws IOException {

        rutaDataset = PLANTILLA_RUTA.replace("{}", clase.getSimpleName().toLowerCase());

        lector = new CsvToBeanBuilder<T>(new FileReader(rutaDataset))
                .withType(clase)
                .build();

        escritor = new StatefulBeanToCsvBuilder<T>(new FileWriter(rutaDataset, true))
                .build();
    }

    public void agregar(T t) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        escritor.write(t);
    }

    public List<T> getTodos() {
        return lector.parse();
    }

    public abstract T get(ID id);

    public void modificar(ID id, T nuevo) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException {
        eliminar(id);
        escritor.write(nuevo);
    }

    public abstract void eliminar(ID id) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException;

    // TODO: Mejorar la lógica de este método
    public void eliminarTodos() throws IOException {
        try (var extractor = new BufferedReader(new FileReader(rutaDataset))) {

            var primeraLinea = extractor.readLine();

            var ruta = Path.of(rutaDataset);
            Files.deleteIfExists(ruta);
            Files.writeString(ruta, primeraLinea);
        }
    }
}
