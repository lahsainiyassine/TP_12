
TP 12 Gestion Fichiers/
├── bin/
├── input.txt                   // Fichier source pour les tests de lecture
├── data.csv                    // Données brutes en entrée (id, nom, score)
├── output.txt                  // Copie générée avec ligne de résumé
├── passed.csv                  // Données CSV filtrées (score >= 50)
├── records.ser                 // Fichier binaire généré par sérialisation
├── application.log             // Fichier journal généré en mode append
├── report.csv                  // Rapport CSV généré par PrintWriter
├── index.html                  // Page web basique générée en UTF-8
└── src/
    └── com/
        └── example/
            └── tp/
                ├── Record.java            // Modèle métier implémentant Serializable
                ├── TextReader.java        // Lecture bufferisée ligne par ligne
                ├── TextWriter.java        // Copie de texte et ajout de métadonnées
                ├── CsvParser.java         // Parsing et écriture de flux CSV
                ├── ObjectSerializer.java  // Sérialisation binaire (ObjectStream)
                ├── Main.java              // Point d'entrée Partie 1
                ├── LogManager.java        // Journalisation horodatée (append mode)
                ├── CsvWriter.java         // Écriture tabulaire via PrintWriter
                ├── HtmlGenerator.java     // Génération HTML avec encodage UTF-8
                └── MainPrintWriter.java   // Point d'entrée Partie 2

1. Flux de Caractères et Bufférisation
BufferedReader & FileReader : Réduction des accès disque grâce à la lecture par blocs via un tampon mémoire (readLine()).

BufferedWriter & FileWriter : Écriture optimisée avec gestion indépendante des séparateurs de lignes (newLine()).

Gestion automatique des ressources : Utilisation systématique du constructeur syntaxique try-with-resources garantissant la libération des descripteurs de fichiers (close()), même en cas de levée d'exception IOException.

2. Manipulation de Données Structurées (CSV)
Parsing textuel : Découpage des lignes via split(","), filtrage des en-têtes et conversion de types primitifs (Integer.parseInt(), Double.parseDouble()).

Filtrage déclaratif : Utilisation de l'API Streams pour extraire des enregistrements respectant un prédicat (score >= 50).







https://github.com/user-attachments/assets/da4f381d-afa7-47ea-aefe-17c859696754


3. Persistance Binaire et Sérialisation
Contrat de sérialisation : Implémentation de l'interface marqueur java.io.Serializable sur la classe Record et définition d'un serialVersionUID.

Flux d'objets : Utilisation conjointe de ObjectOutputStream / FileOutputStream pour l'encodage binaire et de ObjectInputStream / FileInputStream pour la reconstruction dynamique d'arborescences d'objets.

4. Formatage Avancé avec PrintWriter
Mode Ajout (Append) : Initialisation d'un flux d'écriture non destructif via new FileWriter(path, true) pour alimenter un journal d'événements continu (LogManager).

Formatage direct : Emploi de méthodes de haut niveau (printf, println) dispensant de conversions manuelles en chaînes ou en tableaux d'octets.

Encodage de caractères : Spécification explicite du jeu de caractères "UTF-8" lors de la génération de documents structurés (HtmlGenerator).


https://github.com/user-attachments/assets/434f9780-97a0-48a5-a603-d6ae2f2b75f6

