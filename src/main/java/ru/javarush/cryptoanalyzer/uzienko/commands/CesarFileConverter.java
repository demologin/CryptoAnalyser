package ru.javarush.cryptoanalyzer.uzienko.commands;

import ru.javarush.cryptoanalyzer.uzienko.constants.Strings;
import ru.javarush.cryptoanalyzer.uzienko.exceptions.ApplicationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class CesarFileConverter {
    public void convert(String inputFile, String outputFile, int offset) {
        CesarCharConverter alphabetConverter = new CesarCharConverter(Strings.ALPHABET, offset);
        try (FileReader fileReader = new FileReader(inputFile);
             FileWriter fileWriter = new FileWriter(outputFile)) {
            for (int i = fileReader.read(); i > 0; i = fileReader.read()) {
                fileWriter.write(alphabetConverter.convert((char) i));
            }
        } catch (IOException e) {
            throw new ApplicationException("IO error", e);
        }
    }
}
