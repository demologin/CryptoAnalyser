package ru.javarush.cryptoanalyzer.dobrov.commands;

import ru.javarush.cryptoanalyzer.dobrov.constants.Strings;
import ru.javarush.cryptoanalyzer.dobrov.entity.Result;
import ru.javarush.cryptoanalyzer.dobrov.entity.ResultCode;
import ru.javarush.cryptoanalyzer.dobrov.exception.ApplicationException;
import ru.javarush.cryptoanalyzer.dobrov.util.PathFinder;

import java.io.*;


public class Encoder implements Action {
    @Override
    public Result execute(int key) {

        String alphabet = Strings.ALPHABET;
        //TODO Coding. Magic values or methods. Bad reading and understanding
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
