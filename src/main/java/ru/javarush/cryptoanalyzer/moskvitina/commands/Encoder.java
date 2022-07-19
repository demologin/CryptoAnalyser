package ru.javarush.cryptoanalyzer.moskvitina.commands;

import ru.javarush.cryptoanalyzer.moskvitina.entity.Result;
import ru.javarush.cryptoanalyzer.moskvitina.entity.ResultCode;
import ru.javarush.cryptoanalyzer.moskvitina.exceptions.ApplicationException;
import ru.javarush.cryptoanalyzer.moskvitina.util.KeyCalculator;
import ru.javarush.cryptoanalyzer.moskvitina.util.PathFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static ru.javarush.cryptoanalyzer.moskvitina.constants.Dictionary.*;
import static ru.javarush.cryptoanalyzer.moskvitina.constants.FileNames.*;

public class Encoder implements Action {
    @Override
    public Result execute(String[] parameters) {
        String txtFile = "".equals(parameters[0]) ? ENCODED : parameters[0];
        String encodedFile = "".equals(parameters[1]) ? ENCODED : parameters[1];
        int key = KeyCalculator.getKey(Integer.parseInt(parameters[2].isEmpty() ? ENCODED : parameters[2]), charList.size());
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
                        int newAlphabetPosition = Math.abs((originalAlphabetPosition + key) % charList.size());
                        char newCharacter = charList.get(newAlphabetPosition);
                        newLine.append(newCharacter);
                    } else {
                        newLine.append(character);
                    }
                }
                result.append(newLine).append( "\n");
            }
            Files.writeString(writeToFile, result);

        } catch (IOException e) {
            //TODO Coding. Magic values or methods. Bad reading and understanding
            throw new ApplicationException("Файл по пути " + readFromFile + " не найден!", e);
        }
        //TODO Coding. Magic values or methods. Bad reading and understanding
        return new Result(ResultCode.OK, "Зашифровка удалась.\nФайлик вот тут лежит " + writeToFile);


    }
}
