package ru.javarush.cryptoanalyzer.khmelov.command;

import ru.javarush.cryptoanalyzer.khmelov.entity.Result;

public class Encode extends AbstractAction {
    @Override
    public Result execute(String[] parameters) {
        String sourceTextFile = parameters[0];
        String encryptedFile = parameters[1];
        int key = Integer.parseInt(parameters[2]);
        return copyWithKey(sourceTextFile, encryptedFile, key);
    }
}
