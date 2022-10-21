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
import java.util.function.Predicate;

public abstract class Dao<T, ID> {

    private static final String PLANTILLA_RUTA = "dataset/{}.csv";
    protected final String rutaDataset;

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

    public T get(ID id) {

        return lector.parse()
                .stream()
                .filter(mismoId(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No encontrado"));
    }

    public void modificar(ID id, T nuevo) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException {
        eliminar(id);
        escritor.write(nuevo);
    }

    public void eliminar(ID id) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        var registros = lector.parse()
                .stream()
                .filter(distintoId(id));

        eliminarTodos();
        escritor.write(registros);
    }

    public void eliminarTodos() throws IOException {
        try (var extractor = new BufferedReader(new FileReader(rutaDataset))) {

            var primeraLinea = extractor.readLine();

            var ruta = Path.of(rutaDataset);
            Files.deleteIfExists(ruta);
            Files.writeString(ruta, primeraLinea);
        }
    }

    protected abstract Predicate<T> mismoId(ID id);

    protected abstract Predicate<T> distintoId(ID id);
}
