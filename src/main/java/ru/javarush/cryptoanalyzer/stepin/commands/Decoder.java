package ru.javarush.cryptoanalyzer.stepin.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Decoder implements Action {
    private static final Encoder encoder;
    private static final Scanner scanner;

    static {
        encoder = new Encoder();
        scanner = new Scanner(System.in);
    }
    @Override
    public void execute() throws IOException {
        //TODO Coding. We see console (System.out.print) here. Need move the output to View layer
        System.out.println("Введите полный путь к файлу, для его расшифровки:");
        String pathNotEncryptedFile = scanner.nextLine();

        System.out.println("Введите ключ шифрования:");
        int key = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите полный путь к файлу, в который записать расшифрованный текст:");
        String pathEncryptedFile = scanner.nextLine();

        try (var reader = Files.newBufferedReader(Paths.get(pathNotEncryptedFile));
             var writer = Files.newBufferedWriter(Paths.get(pathEncryptedFile))
        ) {
            while (reader.ready()) {
                String string = reader.readLine();
                String encryptString = deEncrypt(string, key);
                writer.write(encryptString + System.lineSeparator());
            }
            System.out.println("Содержимое файла расшифровано.");

        } catch (IOException e) {
            throw new IOException("Путь некорректен");
        }
    }

    public String deEncrypt(String message, int key) {
        return encoder.encrypt(message, key * (-1));
    }
}

