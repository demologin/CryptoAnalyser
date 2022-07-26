package ru.javarush.cryptoanalyzer.borysov.service;

import ru.javarush.cryptoanalyzer.borysov.constants.Alphabet;

import java.io.*;
import java.nio.file.Path;

public class Encode {


    public static String encoder(Path pathLoadFile, Path pathOutputFile, int key) {


        try (Reader reader = new FileReader(String.valueOf(pathLoadFile));
             Writer writer = new FileWriter(String.valueOf(pathOutputFile))
        ) {
            while (reader.ready()) {
                int indexChar = reader.read();
                char origChar = (char) indexChar;
                if (Alphabet.ALPHABET.indexOf(indexChar) != -1) {
                    int indexCharAlphabet = Alphabet.ALPHABET.indexOf(origChar);
                    int encodeChar = (indexCharAlphabet + key) % Alphabet.ALPHABET.length();
                    char newChar = Alphabet.ALPHABET.charAt(encodeChar);
                    writer.write(newChar);
                }
            }
            //TODO Coding. Magic values or methods. Bad reading and understanding
            return "Файл был успешно закодирован";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
