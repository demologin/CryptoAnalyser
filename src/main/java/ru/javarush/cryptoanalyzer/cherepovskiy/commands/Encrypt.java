package ru.javarush.cryptoanalyzer.cherepovskiy.commands;

import ru.javarush.cryptoanalyzer.cherepovskiy.entity.Result;
import ru.javarush.cryptoanalyzer.cherepovskiy.entity.ResultCode;
import ru.javarush.cryptoanalyzer.cherepovskiy.util.PathFinder;

import java.nio.file.Path;

import static ru.javarush.cryptoanalyzer.cherepovskiy.logicpart.EncryptLogic.prepereToEncrypte;

public class Encrypt implements Action {
    @Override
    public Result execute(String[] parametrs) {
        String text = parametrs[0];
        String encrypted = parametrs[1];
        int key = Integer.parseInt(parametrs[2]);
        Path pathIn = Path.of(PathFinder.getRoot() + text);
        Path pathOut = Path.of(PathFinder.getRoot() + encrypted);

        prepereToEncrypte(pathIn, pathOut, key);

        return new Result(ResultCode.OK, "The encryption was successful");
    }
}
