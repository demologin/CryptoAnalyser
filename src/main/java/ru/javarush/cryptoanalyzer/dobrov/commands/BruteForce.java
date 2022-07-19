package ru.javarush.cryptoanalyzer.dobrov.commands;

import ru.javarush.cryptoanalyzer.dobrov.constants.Strings;
import ru.javarush.cryptoanalyzer.dobrov.entity.Result;
import ru.javarush.cryptoanalyzer.dobrov.entity.ResultCode;
import ru.javarush.cryptoanalyzer.dobrov.exception.ApplicationException;
import ru.javarush.cryptoanalyzer.dobrov.util.PathFinder;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BruteForce implements Action {
    //TODO Code style. Incorrect or unexpected order members / modifiers
    String alphabet = Strings.ALPHABET;

    StringBuilder builder = new StringBuilder();

    static int key1;

    @Override
    public Result execute(int key) {
        //TODO Code style. Long code. Needs to be split into several methods

        String path = PathFinder.getRoot() + "encrypt.txt";
        String tempPath = PathFinder.getRoot() + "temp.txt";

        try (

                Reader reader = new BufferedReader(new FileReader(path));
                Writer writer = new BufferedWriter(new FileWriter(tempPath))


        ) {
            for (int i = 1; i < alphabet.length() - 1; i++) {
                reader.mark(1000000000);
                while (reader.ready()) {
                    int startByte = reader.read();
                    char startChar = (char) startByte;
                    if (alphabet.indexOf(startChar) != -1) {
                        int origCharIndexInAlphabet = alphabet.indexOf(startChar);
                        int decryptedIndex = (origCharIndexInAlphabet - i) % alphabet.length();
                        if (decryptedIndex < 0) {
                            decryptedIndex += alphabet.length();
                        }
                        char newCharacter = alphabet.charAt(decryptedIndex);
                        writer.write(newCharacter);
                        builder.append(newCharacter);

                    }
                }
                reader.reset();
                Pattern pattern = Pattern.compile(", [а-яА-Я]");
                Matcher matcher = pattern.matcher(builder);
                if (matcher.find()) {
                    System.out.println("ключ = " + i);
                    key1 = i;
                    bruteText();
                    break;
                }




            }

        } catch (IOException e) {
            throw new ApplicationException(e.getMessage());
        }


        return new Result(ResultCode.OK, "read all bytes " + PathFinder.getRoot() + "brute.txt");

    }

    private void bruteText() {
        try (Reader reader1 = new BufferedReader(new FileReader(PathFinder.getRoot() + "encrypt.txt"));
             Writer writer1 = new BufferedWriter(new FileWriter(PathFinder.getRoot() + "brute.txt"))

        ) {

            while (reader1.ready()) {
                int indexOfOriginalChar = reader1.read();
                char originalChar = (char) indexOfOriginalChar;
                if (alphabet.indexOf(indexOfOriginalChar) != -1) {

                    int origCharIndexInAlphabet = alphabet.indexOf(originalChar);
                    int decryptedIndex = (origCharIndexInAlphabet - key1) % alphabet.length();
                    if (decryptedIndex < 0) {
                        decryptedIndex += alphabet.length();
                    }
                    char newCharacter = alphabet.charAt(decryptedIndex);
                    writer1.write(newCharacter);


                }
            }

        } catch (IOException e) {
            throw new ArithmeticException(e.getMessage());
        }
    }

}
