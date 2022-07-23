package ru.javarush.cryptoanalyzer.stepin.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import static ru.javarush.cryptoanalyzer.stepin.constants.Strings.ALPHABET;

public class Encoder implements Action {
    private static final Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    @Override
    public void execute() throws IOException {
        //TODO Code style. Long code. Needs to be split into several methods
        //TODO Coding. We see console (System.out.print) here. Need move the output to View layer
        System.out.println("Введите полный путь к файлу, для его зашифровки:");
        String pathNotEncryptedFile = scanner.nextLine();

        System.out.println("Введите ключ шифрования:");
        int key = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите полный путь к файлу, в который записать зашифрованый текст:");
        String pathEncryptedFile = scanner.nextLine();

        try (var reader = Files.newBufferedReader(Paths.get(pathNotEncryptedFile));
             var writer = Files.newBufferedWriter(Paths.get(pathEncryptedFile))
        ) {
            while (reader.ready()) {
                String string = reader.readLine();
                String encryptString = encrypt(string, key);
                writer.write(encryptString + System.lineSeparator());
            }
            System.out.println("Содержимое файла зашифровано.");

        } catch (IOException e) {
            throw new IOException("Путь некорректен");
        }
    }

    String encrypt(String message, int key) {
        StringBuilder result = new StringBuilder();

        for (char aChar : message.toCharArray()) {

            int origAlphabetPos = ALPHABET.indexOf(aChar);

            int newAlphabetPos;
            char newCharacter = 0;

            if (origAlphabetPos >= 0) {
                if (key >= 0) {
                    newAlphabetPos = (origAlphabetPos + key) % ALPHABET.length();
                } else {
                    int newKey = key % ALPHABET.length();
                    newAlphabetPos = (origAlphabetPos + ALPHABET.length() + newKey) % ALPHABET.length();
                }
                newCharacter = ALPHABET.charAt(newAlphabetPos);
            }
            result.append(newCharacter);
        }
        return result.toString();
    }
}