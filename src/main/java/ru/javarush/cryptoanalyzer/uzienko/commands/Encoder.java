package ru.javarush.cryptoanalyzer.uzienko.commands;

import ru.javarush.cryptoanalyzer.uzienko.entity.Result;
import ru.javarush.cryptoanalyzer.uzienko.entity.ResultCode;
import ru.javarush.cryptoanalyzer.uzienko.util.PathFinder;

public class Encoder extends CesarFileConverter implements Action {
    @Override
    public Result execute(String[] parameters) {
        String sourceFile = PathFinder.getRoot() + parameters[0];
        String encryptedFile = PathFinder.getRoot() + parameters[1];
        convert(sourceFile, encryptedFile, Integer.parseInt(parameters[2]));
        return new Result(ResultCode.OK, "read all bytes from " + sourceFile);
    }
}
