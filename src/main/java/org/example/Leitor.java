package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Leitor {
    private Path path;
    public Leitor(int caso){
        selecionaCaso(caso);
    }

    private void selecionaCaso(int caso) {
        switch (caso){
            case 1 -> path = Paths.get("src/main/java/org/example/casosD/casoD50.txt");
            case 2 -> path = Paths.get("src/main/java/org/example/casosD/casoD100.txt");
            case 3 -> path = Paths.get("src/main/java/org/example/casosD/casoD200.txt");
            case 4 -> path = Paths.get("src/main/java/org/example/casosD/casoD500.txt");
            case 5 -> path = Paths.get("src/main/java/org/example/casosD/casoD750.txt");
            case 6 -> path = Paths.get("src/main/java/org/example/casosD/casoD1000.txt");
            case 7 -> path = Paths.get("src/main/java/org/example/casosD/casoD1500.txt");
            case 8 -> path = Paths.get("src/main/java/org/example/casosD/casoD2000.txt");
        }
    }

    public char[][] leMapa(){
        try (BufferedReader reader = Files.newBufferedReader(path)){
            String line = reader.readLine();
            Scanner scanner = new Scanner(line).useDelimiter(" ");
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            int nLinha = 0;
            char[][] mapa = new char[i][j];
            while ((line = reader.readLine()) != null){
                char[] array = line.toCharArray();
                System.arraycopy(array, 0, mapa[nLinha], 0, array.length);
                nLinha++;
            }
            return mapa;
        } catch (IOException e){
            System.err.format("Erro de E/S: %s%n", e);
        }
        return null;
    }
}
