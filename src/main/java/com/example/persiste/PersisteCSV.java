package com.example.persiste;

import com.opencsv.CSVWriter;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PersisteCSV {

    public static void salvar(String nomeArquivo, List<String[]> linhas, String[] cabecalho) throws IOException {

        Writer writer = Files.newBufferedWriter(Paths.get(nomeArquivo + ".csv"));
        CSVWriter csvWriter = new CSVWriter(writer);

        csvWriter.writeNext(cabecalho);
        csvWriter.writeAll(linhas);

        csvWriter.flush();
        writer.close();
    }
    
}
