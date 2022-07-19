package ru.javarush.cryptoanalyser.marzhiievskyi.commands;

import ru.javarush.cryptoanalyser.marzhiievskyi.constants.Strings;
import ru.javarush.cryptoanalyser.marzhiievskyi.entity.Result;
import ru.javarush.cryptoanalyser.marzhiievskyi.entity.ResultCode;
import ru.javarush.cryptoanalyser.marzhiievskyi.exeptions.AppException;
import ru.javarush.cryptoanalyser.marzhiievskyi.util.PathFinder;

import java.io.*;
import java.util.*;

public class TextAnalyzer implements Action {


    @Override
    public Result execute(String[] parameters) {

        String inputEncryptedFile = parameters[0];
        String decryptedTextFile = parameters[1];
        String dictionaryTextFile = parameters[2];


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PathFinder.getRoot() + inputEncryptedFile));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PathFinder.getRoot() + decryptedTextFile));
             BufferedReader bufferedReaderDictionary = new BufferedReader(new FileReader(PathFinder.getRoot() + dictionaryTextFile))) {

            Map<Character, Integer> mapOfEncryptedText = gettingCountsOfChars(bufferedReader);
            Map<Character, Integer> mapOfDictionaryTextChars = gettingCountsOfChars(bufferedReaderDictionary);
            Map<Character, Character> alphabetToDecrypt = new HashMap<>();

            Map<Integer, Character> sortedCharsByCountedDict = sortByCounting(mapOfDictionaryTextChars);
            Map<Integer, Character> sortedCharsByCountEncoded = sortByCounting(mapOfEncryptedText);

            int allCharsDict = gettingCharsSumFromMap(mapOfDictionaryTextChars);
            int allCharsEncrypted = gettingCharsSumFromMap(mapOfEncryptedText);

            for (var el : sortedCharsByCountedDict.entrySet()) {
                double percentDict = (double) el.getKey() / allCharsDict * 100;

                for (var elEncoded : sortedCharsByCountEncoded.entrySet()) {
                    double percentEncrypted = (double) elEncoded.getKey() / allCharsEncrypted * 100;
                    double between = percentDict / percentEncrypted;
                    if (between > 0.9 && between <= 1.1) {
                        alphabetToDecrypt.put(el.getValue(), elEncoded.getValue());
                        break;
                    }
                }
            }

            try (BufferedReader fileReader = new BufferedReader(new FileReader(PathFinder.getRoot() + inputEncryptedFile))) {
                while (fileReader.ready()) {
                    char redChar = (char) fileReader.read();
                    for (var el : alphabetToDecrypt.entrySet()) {
                        if (redChar == el.getValue()) {
                            bufferedWriter.write(el.getKey());
                        }
                    }
                }
                return new Result(ResultCode.OK, "Расшифрование закончено. Проверте результат." +
                        "\nПуть к результату: " + PathFinder.getRoot() + decryptedTextFile);
            }

        } catch (IOException e) {
            throw new AppException(Strings.IO_EXCEPTION_MSG, e);
        }
    }

    private Map<Character, Integer> gettingCountsOfChars(BufferedReader bufferedReader) throws IOException {

        Map<Character, Integer> characterIntegerTreeMap = new TreeMap<>();

        while (bufferedReader.ready()) {
            char ch = (char) bufferedReader.read();
            characterIntegerTreeMap.merge(ch, 1, Integer::sum);
        }
        return characterIntegerTreeMap;
    }

    private Integer gettingCharsSumFromMap(Map<Character, Integer> sortedMap) {
        int allChars = 0;
        for (var el : sortedMap.entrySet()) {
            allChars = allChars + el.getValue();
        }
        return allChars;
    }

    private Map<Integer, Character> sortByCounting(Map<Character, Integer> characterMap) {
        Map<Integer, Character> sortedByCountingMap = new TreeMap<>();
        for (var el : characterMap.entrySet()) {
            sortedByCountingMap.put(el.getValue(), el.getKey());
        }
        return sortedByCountingMap;
    }
}
