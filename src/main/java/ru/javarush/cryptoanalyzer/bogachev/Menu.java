package ru.javarush.cryptoanalyzer.bogachev;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final List<MenuEntry> entries = new ArrayList<>();
    private boolean isExit = false;
    private int userKey;


    public Menu() {
        entries.add(new MenuEntry("Encryption") {
            //TODO ---  anno class? Why?
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please give me a key");
                try {
                    userKey = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("\nPlease use an integer");
                    run();
                }
                System.out.println("Please give me input file directory (without .txt) or press enter to use default (input.txt)");
                String inputPath = scanner.nextLine();
                if (!inputPath.equals("")) {
                    Main.inputFile = inputPath + ".txt";
                }
                System.out.println("Please give me encrypt file directory (without .txt) or press enter to use default (encrypt.txt)");
                String outputPath = scanner.nextLine();
                if (!outputPath.equals("")) {
                    Main.encryptFile = outputPath + ".txt";
                }
                try (FileInputStream inputStream = new FileInputStream(Main.inputFile);
                     Scanner sc = new Scanner(inputStream, StandardCharsets.UTF_8)) {
                    StringBuilder str = new StringBuilder();
                    sc.useDelimiter("");
                    while (sc.hasNext()) {
                        str.append(Main.encrypt(sc.next().charAt(0), userKey));
                    }
                    Main.writeToFile(Main.encryptFile, str.toString());
                } catch (IOException e) {
                    System.out.println("\nPlease use correct file name\n");
                    Main.inputFile = "input.txt";
                    Main.encryptFile = "encrypt.txt";
                    run();
                }
            }
        });

        entries.add(new MenuEntry("Decryption with key") {
            @Override
            public void run() {
                Scanner consoleScanner = new Scanner(System.in);

                System.out.println("Please give me a key or press enter and i will use key from encryption: " + userKey);
                String newKey = consoleScanner.nextLine();
                if (!newKey.equals("")) {
                    try {
                        userKey = Integer.parseInt(newKey);
                    } catch (NumberFormatException e) {
                        System.out.println("\nPlease use an integer");
                        run();
                    }
                }
                System.out.println("Please give me encrypt file directory (without .txt) or press enter to use default (encrypt.txt)");
                String encryptPath = consoleScanner.nextLine();
                if (!encryptPath.equals("")) {
                    Main.encryptFile = encryptPath + ".txt";
                }
                try (FileInputStream inputStream = new FileInputStream(Main.encryptFile);
                     Scanner fileScanner = new Scanner(inputStream, StandardCharsets.UTF_8)) {
                    StringBuilder str = new StringBuilder();
                    fileScanner.useDelimiter("");
                    while (fileScanner.hasNext()) {
                        str.append(Main.decrypt(fileScanner.next().charAt(0), userKey));
                    }
                    Main.writeToFile(Main.decryptFile, str.toString());
                    System.out.println("Default decrypt file in project directory: decrypt.txt \n");
                } catch (IOException e) {
                    Main.encryptFile = "encrypt.txt";
                    System.out.println("\nPlease use correct file name\n");
                    run();
                }
            }
        });

        entries.add(new MenuEntry("Decryption by Brute Force") {
            @Override
            public void run() {
                System.out.println("Please give me encrypt file directory (without .txt) or press enter to use default (encrypt.txt)");
                Scanner consoleScanner = new Scanner(System.in);
                String brutePath = consoleScanner.nextLine();
                if (!brutePath.equals("")) {
                    Main.encryptFile = brutePath + ".txt";
                }
                System.out.println("Please wait");
                try (FileInputStream inputStream = new FileInputStream(Main.encryptFile);
                     Scanner fileScanner = new Scanner(inputStream, StandardCharsets.UTF_8)) {
                    String encryptText = Files.readString(Path.of(Main.encryptFile), StandardCharsets.UTF_8);
                    int bruteKey = Main.bruteForce(encryptText);
                    StringBuilder stringBuilder = new StringBuilder();
                    fileScanner.useDelimiter("");
                    while (fileScanner.hasNext()) {
                        stringBuilder.append(Main.decrypt(fileScanner.next().charAt(0), bruteKey));
                    }
                    Main.writeToFile(Main.decryptFile, stringBuilder.toString());
                    System.out.println("Default decrypt file in project directory: decrypt.txt \n");
                } catch (IOException e) {
                    Main.encryptFile = "encrypt.txt";
                    System.out.println("\nPlease use correct file name\n");
                    run();
                }
            }
        });

        entries.add(new MenuEntry("Decryption by Statistical Analysis of Russian characters") {
            @Override
            public void run() {
                Scanner consoleScanner = new Scanner(System.in);

                System.out.println("Please give me encrypt file directory (without .txt) or press enter to use default (encrypt.txt)");
                String encryptPath = consoleScanner.nextLine();
                if (!encryptPath.equals("")) {
                    Main.encryptFile = encryptPath + ".txt";
                }

                System.out.println("Please give me dictionary file directory (without .txt) or press enter to use default (dictionary.txt)");
                String dictionaryPath = consoleScanner.nextLine();
                if (!dictionaryPath.equals("")) {
                    Main.dictionary = dictionaryPath + ".txt";
                }

                System.out.println("Please wait");

                try (FileInputStream inputStream = new FileInputStream(Main.encryptFile);
                     Scanner fileScanner = new Scanner(inputStream, StandardCharsets.UTF_8)) {
                    int keyFromStatAnDecryption = Main.statShift(Main.chiSquares(Main.encryptFile, Main.dictionary));
                    StringBuilder stringBuilder = new StringBuilder();
                    fileScanner.useDelimiter("");
                    while (fileScanner.hasNext()) {
                        stringBuilder.append(Main.decrypt(fileScanner.next().charAt(0), keyFromStatAnDecryption));
                    }
                    Main.writeToFile(Main.decryptFile, stringBuilder.toString());
                    System.out.println("Default decrypt file in project directory: decrypt.txt \n");
                } catch (IOException e) {
                    //TODO Coding. Magic values or methods. Bad reading and understanding
                    Main.dictionary = "dictionary.txt";
                    Main.encryptFile = "encrypt.txt";
                    System.out.println("\nPlease use correct file name\n");
                    run();
                }
            }
        });
        entries.add(new MenuEntry("Exit") {
            @Override
            public void run() {
                isExit = true;
            }
        });
    }

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (!isExit) {
            printMenu();
            int choice = 0;
            try {
                String line = reader.readLine();
                choice = Integer.parseInt(line);
                if (choice < 1 || choice > 5) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (IOException | IndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("\nPlease make the right choice (1-5)\n");
                run();
            }
            MenuEntry entry = entries.get(choice - 1);
            entry.run();
        }
    }

    private void printMenu() {
        System.out.println("What do you want to do (enter the number):");
        for (int i = 0; i < entries.size(); i++) {
            System.out.println(i + 1 + ". " + entries.get(i).getTitle());
        }
        System.out.println();
    }

}

