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
import static ru.javarush.cryptoanalyser.moskvitina.constants.FileNames.*;

public class Decoder implements Action {
    @Override
    public Result execute(String[] parameters) {
        String txtFile = "".equals(parameters[0]) ? DECODED : parameters[0];
        String encodedFile = "".equals(parameters[1]) ? DECODED : parameters[1];
        int key = KeyCalculator.getKey(Integer.parseInt(parameters[2].isEmpty() ? DECODED : parameters[2]), charList.size());
        Path readFromFile = Path.of(PathFinder.getRoot() + txtFile);
        Path writeToFile = Path.of(PathFinder.getRoot() + encodedFile);
        StringBuilder result = new StringBuilder();
        try {
            List<String> strings = Files.readAllLines(readFromFile);

            for (String line : strings) {
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
                result.append(newLine).append("\n");
            }
            Files.writeString(writeToFile, result);

        } catch (IOException e) {
            throw new ApplicationException("Файл по пути " + readFromFile + " не найден!", e);
        }
        return new Result(ResultCode.OK, "Расшифровка выполнена.\nФайлик вот тут лежит " + writeToFile);


    }
}

