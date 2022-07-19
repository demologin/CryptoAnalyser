package ru.javarush.cryptoanalyser.uzienko.commands;

import ru.javarush.cryptoanalyser.uzienko.entity.Result;
import ru.javarush.cryptoanalyser.uzienko.entity.ResultCode;
import ru.javarush.cryptoanalyser.uzienko.util.PathFinder;

public class Decoder extends CesarFileConverter implements Action {
    @Override
    public Result execute(String[] parameters) {
        String encryptedFile = PathFinder.getRoot() + parameters[0];
        String decryptedFile = PathFinder.getRoot() + parameters[1];
        convert(encryptedFile, decryptedFile, -Integer.parseInt(parameters[2]));
        return new Result(ResultCode.OK, "read all bytes from " + encryptedFile);
    }
}
