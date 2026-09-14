package com.example.tp;

import java.util.Arrays;
import java.util.List;

public class MainPrintWriter {
    public static void main(String[] args) {
        System.out.println("=== Test 1 : Journalisation ===");
        LogManager logger = new LogManager("application.log");
        logger.log("INFO", "Démarrage de l’application");
        logger.log("DEBUG", "Chargement de la configuration");
        logger.log("ERROR", "Impossible de se connecter à la base");
        System.out.println("Lignes écrites dans application.log");

        System.out.println("\n=== Test 2 : Génération CSV ===");
        List<String> header = Arrays.asList("id", "nom", "score");
        List<String[]> rows = List.of(
            new String[]{"1", "Alice", "85"},
            new String[]{"2", "Bob", "92"},
            new String[]{"3", "Carol", "78"}
        );
        CsvWriter.writeCsv("report.csv", header, rows);
        System.out.println("Fichier report.csv généré.");

        System.out.println("\n=== Test 3 : Génération HTML ===");
        HtmlGenerator.writeHtml(
            "index.html",
            "Ma première page",
            "Bienvenue sur ma page générée par PrintWriter !"
        );
        System.out.println("Fichier index.html généré.");
    }
}