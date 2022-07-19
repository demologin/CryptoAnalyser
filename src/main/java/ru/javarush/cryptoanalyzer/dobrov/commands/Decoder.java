package ru.javarush.cryptoanalyzer.dobrov.commands;

import ru.javarush.cryptoanalyzer.dobrov.constants.Strings;
import ru.javarush.cryptoanalyzer.dobrov.entity.Result;
import ru.javarush.cryptoanalyzer.dobrov.entity.ResultCode;
import ru.javarush.cryptoanalyzer.dobrov.util.PathFinder;

import java.io.*;

public class Decoder implements Action {
    @Override
    public Result execute(int key) {

        String alphabet = Strings.ALPHABET;

        String path = PathFinder.getRoot() + "encrypt.txt";
        String decryptPath = PathFinder.getRoot() + "decrypt.txt";

        try (Reader reader = new FileReader(path);
             Writer writer = new FileWriter(decryptPath)

        ) {

            while (reader.ready()) {
                int indexOfOriginalChar = reader.read();
                char originalChar = (char) indexOfOriginalChar;
                if (alphabet.indexOf(indexOfOriginalChar) != -1) {

                    int origCharIndexInAlphabet = alphabet.indexOf(originalChar);
                    int decryptedIndex = (origCharIndexInAlphabet - key) % alphabet.length();
                    if (decryptedIndex < 0) {
                        decryptedIndex += alphabet.length();
                    }
                    char newCharacter = alphabet.charAt(decryptedIndex);
                    writer.write(newCharacter);


                }
            }

        } catch (IOException e) {
            throw new ArithmeticException(e.getMessage());
        }


        return new Result(ResultCode.OK, "read all bytes " + decryptPath);

    }
}
