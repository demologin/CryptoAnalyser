package ru.javarush.cryptoanalyzer.parfenov.commands;

import ru.javarush.cryptoanalyzer.parfenov.arguments.ArgumentTypes;
import ru.javarush.cryptoanalyzer.parfenov.entity.Result;
import ru.javarush.cryptoanalyzer.parfenov.exception.ApplicationException;

import java.nio.file.Path;
import java.util.Map;

public class Decrypt extends AbstractCrypt implements Action{
    @Override
    public Result execute(Map<ArgumentTypes, Object> arguments) {
        try {
            Path inputFile = (Path) arguments.get(ArgumentTypes.INPUT_FILE);
            Path outputFile = (Path) arguments.get(ArgumentTypes.OUTPUT_FILE);
            int key = (int) arguments.get(ArgumentTypes.KEY);
            key *= -1;
            String alphabet = (String) arguments.get(ArgumentTypes.ALPHABET);
            return getResult(inputFile, outputFile, key, alphabet, false);
        } catch(ClassCastException e) {
            throw new ApplicationException("Something went wrong with casting: ", e);
        }
    }
}
