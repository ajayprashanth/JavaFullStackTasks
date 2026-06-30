package fileprograms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileMenuNoTryCatch {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n----- File Menu -----");
            System.out.println("1) Create File");
            System.out.println("2) Write Lines");
            System.out.println("3) Read Lines");
            System.out.println("4) Exit");
            System.out.print("Enter your choice: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    createFile(sc);
                    break;

                case 2:
                    writeLines(sc);
                    break;

                case 3:
                    readLines(sc);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }

    // Create File
    private static void createFile(Scanner sc) throws IOException {

        System.out.print("Enter file name: ");
        String name = sc.nextLine();

        File file = new File(name + ".txt");

        if (file.createNewFile()) {
            System.out.println("File created successfully: " + file.getName());
        } else {
            System.out.println("File already exists.");
        }
    }

    // Write Lines
    private static void writeLines(Scanner sc) throws IOException {

        System.out.print("Enter file name: ");
        String name = sc.nextLine();

        File file = new File(name + ".txt");

        if (!file.exists()) {
            System.out.println("File does not exist. Create it first.");
            return;
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

        System.out.println("Enter lines (Type STOP to finish):");

        String line;

        while (!(line = sc.nextLine()).equalsIgnoreCase("STOP")) {
            writer.write(line);
            writer.newLine();
        }

        writer.close();

        System.out.println("Lines written successfully.");
    }

    // Read Lines
    private static void readLines(Scanner sc) throws IOException {

        System.out.print("Enter file name: ");
        String name = sc.nextLine();

        File file = new File(name + ".txt");

        if (!file.exists()) {
            System.out.println("File does not exist.");
            return;
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;

        System.out.println("\n----- File Contents -----");

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();
    }
}

