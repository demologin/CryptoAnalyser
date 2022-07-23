package ru.javarush.cryptoanalyzer.cherepovskiy.commands;

import ru.javarush.cryptoanalyzer.cherepovskiy.entity.Result;
import ru.javarush.cryptoanalyzer.cherepovskiy.entity.ResultCode;
import ru.javarush.cryptoanalyzer.cherepovskiy.util.PathFinder;

import java.nio.file.Path;

import static ru.javarush.cryptoanalyzer.cherepovskiy.logicpart.AnalizeLogic.startAnalyze;

public class Analyze implements Action {

    @Override
    public Result execute(String[] parametrs) {
        String encrypted = parametrs[0];
        String dictionary = parametrs[1];
        String analysed = parametrs[2];
        Path pathEncrypted = Path.of(PathFinder.getRoot() + encrypted);
        Path pathDictionary = Path.of(PathFinder.getRoot() + dictionary);
        Path pathAnalysed = Path.of(PathFinder.getRoot() + analysed);

        startAnalyze(pathEncrypted, pathDictionary, pathAnalysed);

        return new Result(ResultCode.OK, "The decryption by Alylise was successful");
    }
}
