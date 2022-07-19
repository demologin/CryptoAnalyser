package ru.javarush.cryptoanalyser.karpiza.commands;

import ru.javarush.cryptoanalyser.karpiza.entity.Result;
import ru.javarush.cryptoanalyser.karpiza.entity.ResultCode;
import ru.javarush.cryptoanalyser.karpiza.exception.ApplicationException;
import ru.javarush.cryptoanalyser.karpiza.util.PathFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Encoder implements Action {
    @Override
    public Result execute(String[] parameters) {

        String txtFile = parameters[0];
        String encryptedFile = parameters[0];
        Path path = Path.of(PathFinder.getRoot() + txtFile);
        try {
            List<String> strings = Files.readAllLines(path);
        } catch (IOException e) {
            throw new ApplicationException("IO error", e);
        }
        return new Result(ResultCode.OK, "read all bytes " + path);
    }
}
