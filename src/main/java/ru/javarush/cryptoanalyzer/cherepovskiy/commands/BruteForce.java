package ru.javarush.cryptoanalyzer.cherepovskiy.commands;

import ru.javarush.cryptoanalyzer.cherepovskiy.entity.Result;
import ru.javarush.cryptoanalyzer.cherepovskiy.entity.ResultCode;
import ru.javarush.cryptoanalyzer.cherepovskiy.util.PathFinder;

import java.nio.file.Path;

import static ru.javarush.cryptoanalyzer.cherepovskiy.logicpart.BruteForceLogic.startToBruteForce;

public class BruteForce implements Action {

    @Override
    public Result execute(String[] parametrs) {
        String encrypted = parametrs[0];
        String bruteForce = parametrs[1];
        Path pathIn = Path.of(PathFinder.getRoot() + encrypted);
        Path pathOut = Path.of(PathFinder.getRoot() + bruteForce);

        startToBruteForce(pathIn, pathOut);
        return new Result(ResultCode.OK, "The decryption by Brut force was successful");
    }
}
