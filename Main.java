import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // File path (modify as per your location)
        String filePath = "example.txt";

        // Write to file
        writeFile(filePath, "This is the first line of the file.\nThis is the second line.");

        // Read the file content
        System.out.println("File content before modification:");
        readFile(filePath);

        // Modify the file
        modifyFile(filePath, "This is the second line of the file.\nThis is the third line added during modification.");

        // Read the file content after modification
        System.out.println("File content after modification:");
        readFile(filePath);
    }

    // Method to write content to a file
    public static void writeFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    // Method to read the content of a file
    public static void readFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    // Method to modify an existing file
    public static void modifyFile(String filePath, String newContent) {
        try {
            // Read all lines from the file
            Path path = Paths.get(filePath);
            String existingContent = new String(Files.readAllBytes(path));

            // Append new content
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                writer.write(newContent);
                System.out.println("File modified successfully.");
            }

        } catch (IOException e) {
            System.err.println("An error occurred while modifying the file: " + e.getMessage());
        }
    }
}
