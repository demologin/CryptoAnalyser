package ru.javarush.cryptoanalyzer.shubchynskyi.commands;

import ru.javarush.cryptoanalyzer.shubchynskyi.constans.Strings;
import ru.javarush.cryptoanalyzer.shubchynskyi.entity.Result;


public class Encoder implements Action {
    @Override
    public Result execute(String[] parameters) {
        String sourceTextFile = parameters[0];
        String encryptedFile = parameters[1];
        int key = Integer.parseInt(parameters[2]) % Strings.ALPHABET.length();
        return copyWithKey(sourceTextFile, encryptedFile, key);
    }
}
