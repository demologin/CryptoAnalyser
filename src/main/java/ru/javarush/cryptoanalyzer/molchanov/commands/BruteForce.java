package ru.javarush.cryptoanalyzer.molchanov.commands;

import ru.javarush.cryptoanalyzer.molchanov.Exception.ApplicationException;
import ru.javarush.cryptoanalyzer.molchanov.constants.Strings;
import ru.javarush.cryptoanalyzer.molchanov.entity.Result;
import ru.javarush.cryptoanalyzer.molchanov.entity.ResultCode;
import ru.javarush.cryptoanalyzer.molchanov.util.PathFinder;
import ru.javarush.cryptoanalyzer.molchanov.util.TextUtilMethods;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class BruteForce implements Action{
    @Override
    public Result execute(String[] parameters) {
        String txtFile = parameters[0];
        String encryptedFile = parameters[1];
        Path pathIn = Path.of(PathFinder.getRoot() + txtFile);
        Path pathOut = Path.of(PathFinder.getRoot() + encryptedFile);
        List<String> lines;
        try {
            lines = Files.readAllLines(pathIn, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new ApplicationException("FileNotFound");
        }
        char[] textInChar = TextUtilMethods.textInCharArray(lines);
        int key = KeyDecoding(textInChar);
        Decoder.decoding(textInChar, key);

        try {
            Files.writeString(pathOut, String.copyValueOf(textInChar));
        } catch (IOException e) {
            return new Result(ResultCode.ERROR, "Writing to file failed" + pathOut);
        }
        return new Result(ResultCode.OK, "Text was decoded" + pathOut);
    }

    //TODO Code style. Incorrect or unexpected order members / modifiers
    protected static int KeyDecoding (char[] allSymbols){
        int maxCountOfCont = 0;
        int bestKey = 0;
        for (int i = 0; i < Strings.ALPHABET.size(); i++) {
            char[] copy = Arrays.copyOf(allSymbols, allSymbols.length);
            Decoder.decoding(copy, i);
            String text = String.valueOf(copy);
            int counter = 0;
            for (String dec: Strings.decod) {
                if(text.contains(dec)) {
                    counter++;
                }
            }
            if(maxCountOfCont<counter){
                maxCountOfCont = counter;
                bestKey = i;
            }
        }
        return bestKey;
    }

}
