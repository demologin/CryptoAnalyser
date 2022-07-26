package ru.javarush.cryptoanalyzer.gamora.actions.basicactions;

import ru.javarush.cryptoanalyzer.gamora.entity.Result;
import ru.javarush.cryptoanalyzer.gamora.entity.ResultCode;
import ru.javarush.cryptoanalyzer.gamora.util.PathFinder;

import java.util.*;

public class Encoder extends AbstractAction {
    @Override
    public Result execute() {
        currentText = currentText.toLowerCase();
        Map<Character, Character> charMapping = getCharacterMapping(key);
        currentText = mapText(charMapping);
        writeResult();
        return new Result(ResultCode.OK);
    }

    @Override
    public void build(String[] args) {
        readPath = PathFinder.pathFinder.getFilePath(args, 1);
        writePath = PathFinder.pathFinder.getFilePath(args, 2);
        currentText = readFromFile(readPath);
        key = Integer.parseInt(args[3]);
    }
}
