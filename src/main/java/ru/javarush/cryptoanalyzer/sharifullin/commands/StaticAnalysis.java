package ru.javarush.cryptoanalyzer.sharifullin.commands;

import ru.javarush.cryptoanalyzer.sharifullin.entity.Result;
import ru.javarush.cryptoanalyzer.sharifullin.entity.ResultCode;
import ru.javarush.cryptoanalyzer.sharifullin.exception.ApplicationException;
import ru.javarush.cryptoanalyzer.sharifullin.util.CountOfCharacters;
import ru.javarush.cryptoanalyzer.sharifullin.util.PathFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StaticAnalysis implements Action{
    @Override
    public Result execute(String[] parameters) {
        String encryptedFile = parameters[0];
        String exampleFile = parameters[1];
        String analysisFile = parameters[2];
        Path pathReadEncodedFile = Path.of(PathFinder.getRoot() + encryptedFile);
        Path pathReadExampleFile = Path.of(PathFinder.getRoot() + exampleFile);
        Path pathWriteFile = Path.of(PathFinder.getRoot() + analysisFile);
        CountOfCharacters read = new CountOfCharacters();
        Map<Character, Integer> statisticSymbolsEncodedFile = read.countOfChar(pathReadEncodedFile);
        Map<Character, Integer> statisticSymbolsDecodedFile = read.countOfChar(pathReadExampleFile);

        String reader = null;
        try {
            reader = Files.readString(pathReadEncodedFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        char[] encodedFileToChar = reader.toCharArray();
        List<Character> countForEnterSymbolsToEncFile = new ArrayList<>(statisticSymbolsEncodedFile.keySet());
        List<Character> countForEnterSymbolsToDecFile = new ArrayList<>(statisticSymbolsDecodedFile.keySet());

        for (int i = 0; i < countForEnterSymbolsToEncFile.size(); i++) {
            for (int j = 0; j < encodedFileToChar.length; j++) {
                int x = Character.compare(countForEnterSymbolsToEncFile.get(i), encodedFileToChar[j]);
                if (x == 0) {
                    encodedFileToChar[j]= countForEnterSymbolsToDecFile.get(i);
                }
            }
        }
        try {
            Files.writeString(pathWriteFile, String.valueOf(encodedFileToChar));
        } catch (IOException e) {
            throw new ApplicationException("IO error", e);
        }
        return new Result(ResultCode.OK, "The file is encoded. Path for file " + pathWriteFile);

    }
}
