package ru.javarush.cryptoanalyser.dobrov.commands;

import ru.javarush.cryptoanalyser.dobrov.constants.Strings;
import ru.javarush.cryptoanalyser.dobrov.entity.Result;
import ru.javarush.cryptoanalyser.dobrov.entity.ResultCode;
import ru.javarush.cryptoanalyser.dobrov.exception.ApplicationException;
import ru.javarush.cryptoanalyser.dobrov.util.PathFinder;

import java.io.*;


public class Encoder implements Action {
    @Override
    public Result execute(int key) {

        String alphabet = Strings.ALPHABET;

        String path = PathFinder.getRoot() + "text.txt";
        String encryptPath = PathFinder.getRoot() + "encrypt.txt";

        try (Reader reader = new FileReader(path);
             Writer writer = new FileWriter(encryptPath)

        ) {

            while (reader.ready()) {
                int originalChar = reader.read();
                char origChar = (char) originalChar;
                if (alphabet.indexOf(originalChar) != -1) {

                    int origCharIndexInAlphabet = alphabet.indexOf(origChar);
                    int encryptedChar = (origCharIndexInAlphabet + key) % alphabet.length();
                    char newCharacter = alphabet.charAt(encryptedChar);
                    writer.write(newCharacter);


                }
            }

        } catch (IOException e) {
            throw new ApplicationException(e.getMessage());
        }


        return new Result(ResultCode.OK, "read all bytes " + encryptPath);

    }
}
