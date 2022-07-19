package ru.javarush.cryptoanalyser.uzienko.commands;

import ru.javarush.cryptoanalyser.uzienko.entity.Result;
import ru.javarush.cryptoanalyser.uzienko.entity.ResultCode;
import ru.javarush.cryptoanalyser.uzienko.util.PathFinder;

public class Encoder extends CesarFileConverter implements Action {
    @Override
    public Result execute(String[] parameters) {
        String sourceFile = PathFinder.getRoot() + parameters[0];
        String encryptedFile = PathFinder.getRoot() + parameters[1];
        convert(sourceFile, encryptedFile, Integer.parseInt(parameters[2]));
        return new Result(ResultCode.OK, "read all bytes from " + sourceFile);
    }
}
