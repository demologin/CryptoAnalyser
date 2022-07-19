package ru.javarush.cryptoanalyser.moskvitina.commands;

import ru.javarush.cryptoanalyser.moskvitina.entity.Result;
import ru.javarush.cryptoanalyser.moskvitina.entity.ResultCode;
import ru.javarush.cryptoanalyser.moskvitina.exceptions.ApplicationException;
import ru.javarush.cryptoanalyser.moskvitina.util.KeyCalculator;
import ru.javarush.cryptoanalyser.moskvitina.util.PathFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static ru.javarush.cryptoanalyser.moskvitina.constants.Dictionary.charList;
import static ru.javarush.cryptoanalyser.moskvitina.constants.FileNames.BRUTEFORCED;

public class Bruteforce implements Action{

    @Override
    public Result execute(String[] parameters) {

        String txtFile = "".equals(parameters[0]) ? BRUTEFORCED : parameters[0];
        String encodedFile = "".equals(parameters[1]) ? BRUTEFORCED : parameters[1];
        Path readFromFile = Path.of(PathFinder.getRoot() + txtFile);
        Path writeToFile = Path.of(PathFinder.getRoot() + encodedFile);
        StringBuilder result = new StringBuilder();

        try {
            List<String> allLines = Files.readAllLines(readFromFile);
            String checkedLine = allLines.get(0) + allLines.get(1) + allLines.get(2) + allLines.get(3) + allLines.get(4) + allLines.get(5) + allLines.get(6);
            int key = KeyCalculator.getKey(checkedLine);


            for (String line : allLines) {
                StringBuilder newLine = new StringBuilder();
                for (char character : line.toCharArray()) {
                    if (charList.contains(character)) {
                        int originalAlphabetPosition = charList.indexOf(character);
                        int newAlphabetPosition = Math.abs((originalAlphabetPosition + (charList.size() - (key % charList.size()))) % charList.size());
                        char newCharacter = charList.get(newAlphabetPosition);
                        newLine.append(newCharacter);
                    } else {
                        newLine.append(character);
                    }
                }
                result.append(newLine).append( "\n");
            }
            Files.writeString(writeToFile, result);
            return new Result(ResultCode.OK, "Взлом удался.\nКлюч = " + key + ". Файлик вот тут лежит " + writeToFile);

        } catch (IOException e) {
            throw new ApplicationException("Файл по пути " + readFromFile + " не найден!", e);
        }

    }
}
