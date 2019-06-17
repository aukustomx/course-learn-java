package com.bbva.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesTest {

    public static void main(String[] args) throws Exception {

       // printFileLines("C:\\Users\\administradorcito\\IdeaProjects" +
       //         "\\validator\\src\\main\\resources\\registros.txt");

       // printFileLinesContaining("C:\\Users\\administradorcito\\IdeaProjects" +
       //         "\\validator\\src\\main\\resources\\bigFile.txt", "<api ");

        writeToFile("C:\\Users\\administradorcito\\IdeaProjects" +
                "\\validator\\src\\main\\resources\\helloFile.txt");
    }

    public static void printFileLines(String fileFullPath) throws Exception {
        Path path = Paths.get(fileFullPath);

        Files.readAllLines(path).stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    public static void printFileLinesContaining(String fileFullPath, String match) throws Exception {

        Path path = Paths.get(fileFullPath);

        BufferedReader reader = Files.newBufferedReader(path);
        String line = reader.readLine();

        while (null != line) {
            if (line.contains(match)) {
                System.out.println(line);
            }
            line = reader.readLine();
        }

        reader.close();
    }

    public static void writeToFile(String filename) throws Exception {
        String str = "¡Hola mundo!";
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
        writer.write(str);
        writer.close();
    }
}
