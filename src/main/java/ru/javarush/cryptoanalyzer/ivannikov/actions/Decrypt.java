package ru.javarush.cryptoanalyzer.ivannikov.actions;

import ru.javarush.cryptoanalyzer.ivannikov.exception.ApplicationException;
import ru.javarush.cryptoanalyzer.ivannikov.util.PathFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

import static ru.javarush.cryptoanalyzer.ivannikov.constants.Alphabet.ALPHABET;
import static ru.javarush.cryptoanalyzer.ivannikov.constants.Methods.encrypted;

public class Decrypt {
    public static void decrypt() {
        StringBuilder sb = new StringBuilder();
        try (Scanner scanner = new Scanner(System.in)) {
            //TODO Coding. We see console (System.out.print) here. Need move the output to View layer
            System.out.println("Decryption program started");
            System.out.println("enter the key");
            int keyDecrypt = scanner.nextInt();
            // TODO checking for a number
            System.out.println("enter text or file path");
            Thread.sleep(1000);
            System.out.println("file path received, start decryption");
            String encodeFile = "encodeFile.txt";
            String decodedFile = "decodedFile.txt";
            Path path1 = Path.of(PathFinder.getRoot(), encodeFile);
            Path path = Path.of(PathFinder.getRoot(), decodedFile);
            List<String> strings = Files.readAllLines(path1);
            encrypted(sb, ALPHABET.length() - (keyDecrypt % ALPHABET.length()), strings);
            System.out.print(sb);
            Files.writeString(path, sb);
            //TODO Coding. We see console (System.out.print) here. Need move the output to View layer
            System.out.println("\n\nThe program completed successfully, your file is located on " + path);

        } catch (IOException | InterruptedException e) {
            throw new ApplicationException("decrypt");
        }
    }
}

