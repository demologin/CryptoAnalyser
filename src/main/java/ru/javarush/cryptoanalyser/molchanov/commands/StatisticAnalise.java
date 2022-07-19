package ru.javarush.cryptoanalyser.molchanov.commands;

import ru.javarush.cryptoanalyser.molchanov.Exception.ApplicationException;
import ru.javarush.cryptoanalyser.molchanov.entity.Result;
import ru.javarush.cryptoanalyser.molchanov.entity.ResultCode;
import ru.javarush.cryptoanalyser.molchanov.util.PathFinder;
import ru.javarush.cryptoanalyser.molchanov.util.TextUtilMethods;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class StatisticAnalise implements Action{
    @Override
    public Result execute(String[] parameters) {
        String encodedFile = parameters[0];
        String textForAnalise = parameters[1];
        Path pathEncodedText = Path.of(PathFinder.getRoot() + encodedFile);
        Path pathOfTextForAnalise = Path.of(PathFinder.getRoot() + textForAnalise);
        Path pathOut = Path.of(PathFinder.getRoot() + "decoded.txt");
        List<String> linesOfEncodedText;
        List<String> linesOfAnalisedText;

        try {
            linesOfEncodedText = Files.readAllLines(pathEncodedText, StandardCharsets.UTF_8);
            linesOfAnalisedText = Files.readAllLines(pathOfTextForAnalise, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new ApplicationException("FileNotFound");
        }
        char[] encodedTextInChar = TextUtilMethods.textInCharArray(linesOfEncodedText);
        char[] analyzedTextToChar = TextUtilMethods.textInCharArray(linesOfAnalisedText);

        Character[] encodedTextInCharacter = TextUtilMethods.charToCharacterArray(encodedTextInChar);
        Character[] analyzedTextInCharacter= TextUtilMethods.charToCharacterArray(analyzedTextToChar);

        HashMap<Character, Double> encodedTextStatistic = UtilsForStatisticAnalise.textAnalise(encodedTextInCharacter);
        HashMap<Character, Double> analyzedTextStatistic = UtilsForStatisticAnalise.textAnalise(analyzedTextInCharacter);
        System.out.println(encodedTextStatistic);
        System.out.println(analyzedTextStatistic);
        System.out.println(UtilsForStatisticAnalise.statDecoderIt1(encodedTextInChar, encodedTextStatistic, analyzedTextStatistic));


        try {
            Files.writeString(pathOut, UtilsForStatisticAnalise.statDecoderIt1(encodedTextInChar,
                    encodedTextStatistic, analyzedTextStatistic));
        } catch (IOException e) {
            return new Result(ResultCode.ERROR, "Writing to file failed" + pathOut);
        }
        return new Result(ResultCode.OK, "Text was decoded" + pathOut);
    }




}
