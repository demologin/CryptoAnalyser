package ru.javarush.cryptoanalyzer.cherepovskiy.commands;

import ru.javarush.cryptoanalyzer.cherepovskiy.entity.Result;
import ru.javarush.cryptoanalyzer.cherepovskiy.entity.ResultCode;
import ru.javarush.cryptoanalyzer.cherepovskiy.util.PathFinder;

import java.nio.file.Path;

import static ru.javarush.cryptoanalyzer.cherepovskiy.logicpart.DecryptLogic.startToDescrypt;

public class Decrypt implements Action {

    @Override
    public Result execute(String[] parameters) {
        String encrypted = parameters[0];
        String decrypted = parameters[1];
        int key = Integer.parseInt(parameters[2]);
        Path pathIn = Path.of(PathFinder.getRoot() + encrypted);
        Path pathOut = Path.of(PathFinder.getRoot() + decrypted);

        startToDescrypt(pathIn, pathOut, key);

        return new Result(ResultCode.OK, "The decryption was successful");
    }
}
