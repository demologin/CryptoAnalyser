package ru.javarush.cryptoanalyzer.marzhiievskyi.commands;

import ru.javarush.cryptoanalyzer.marzhiievskyi.constants.Strings;

public abstract class DecryptingKeyShift {
    public Character decryptingByKeyShift(Character character, Integer keyShift) {
        int charPos = Strings.ALPHABET_LIST.indexOf(character);
        int keyValue = (charPos - keyShift) % Strings.ALPHABET_LIST.size();
        if (keyValue < 0) {
            keyValue = Strings.ALPHABET_LIST.size() + keyValue;
        }
        return Strings.ALPHABET_LIST.get(keyValue);
    }
}
