package ru.javarush.cryptoanalyzer.mamikonyan.commands;

import static ru.javarush.cryptoanalyzer.mamikonyan.constants.Constants.ALPHABET;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Decoder implements Action {

    @Override
    public void execute(String[] parameters) {
        int key = Integer.parseInt(parameters[0]) % ALPHABET.length();
        String sourceFileName = parameters[1];
        String targetFileName = parameters[2];
        String shiftedAlphabet = ALPHABET.substring(key) + ALPHABET.substring(0, key);

        codingText(sourceFileName, targetFileName, shiftedAlphabet);
    }

    //TODO Coding. Need use OOP here. Many static methods is not best practice.
    static void codingText(String sourceFileName, String targetFileName, String shiftedAlphabet) {
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFileName));
             FileWriter fileWriter = new FileWriter(targetFileName)) {
            while (br.ready()) {
                String line = br.readLine();
                for (int i = 0; i < line.length(); i++) {
                    char curr = line.charAt(i);
                    char currShifted = ALPHABET.charAt(shiftedAlphabet.indexOf(curr));
                    fileWriter.write(currShifted);
                }
                fileWriter.write('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
