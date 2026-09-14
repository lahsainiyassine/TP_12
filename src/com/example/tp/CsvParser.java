package com.example.tp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {

    public static List<Record> readCsv(String path) throws IOException {
        List<Record> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                // Ignore les lignes vides et la ligne d'en-tête éventuelle
                if (line.isEmpty() || line.toLowerCase().startsWith("id,")) {
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    double score = Double.parseDouble(parts[2].trim());
                    records.add(new Record(id, name, score));
                }
            }
        }
        return records;
    }

    public static void writeCsv(List<Record> records, String path) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write("id,name,score");
            bw.newLine();
            for (Record r : records) {
                bw.write(r.getId() + "," + r.getName() + "," + r.getScore());
                bw.newLine();
            }
        }
    }
}