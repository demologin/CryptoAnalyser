package ru.javarush.cryptoanalyzer.petrochenko.commands;

import ru.javarush.cryptoanalyzer.petrochenko.Exceptions.ApplicationException;
import ru.javarush.cryptoanalyzer.petrochenko.constants.Messeges;
import ru.javarush.cryptoanalyzer.petrochenko.constants.Strings;
import ru.javarush.cryptoanalyzer.petrochenko.controller.Commands;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class EncoderOne {
    //TODO Code style. Long code. Needs to be split into several methods
    //TODO Code style. Many warnings. Skip or fix it.
    public EncoderOne(String[]parameters) {
        parameters = Commands.parameters;
        Path txtFile = Path.of(parameters[0]);
        Path encryptedFile = Path.of(parameters[1]);
        int key = Integer.parseInt(parameters[2]);
        char[] alphabet = Strings.ALPHABET.toCharArray();
        List<String> strings2 = new ArrayList<>();
        if (key >= alphabet.length) {
            key = key % alphabet.length;
        }
        try {
            List<String> strings = Files.readAllLines(txtFile);
            for (String string : strings) {
                String str = string.toLowerCase();
                char[] stringToChar = str.toCharArray();
                for (int i = 0; i < stringToChar.length; i++) {
                    for (int j = 0; j < alphabet.length; j++) {
                        if (stringToChar[i] == alphabet[j]) {
                            if ((j + key) < alphabet.length) {
                                stringToChar[i] = alphabet[j + key];
                                break;
                            } else {
                                int n = j + key - alphabet.length;
                                stringToChar[i] = alphabet[n];
                                break;
                            }
                        }
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                for (int k = 0; k < stringToChar.length - 1; k++) {
                    stringBuilder.append(stringToChar[k]);
                }
                strings2.add(stringBuilder.toString());
            }
        } catch (IOException e) {
            throw new ApplicationException("IO error", e);
        }
        try (FileWriter writer = new FileWriter(String.valueOf(encryptedFile))) {
            for (String s : strings2) {
                writer.write(s+"\n");
            }
        } catch (IOException e) {
            throw new ApplicationException("IO error", e);
        }
        System.out.println(Messeges.ooperationCompleted);
    }
}

