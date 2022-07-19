package ru.javarush.cryptoanalyzer.sternard.application;

import ru.javarush.cryptoanalyzer.sternard.exceptions.HandlerExceptions;

import static ru.javarush.cryptoanalyzer.sternard.constant.Alphabet.ALPHABET;
import static ru.javarush.cryptoanalyzer.sternard.constant.Alphabet.ALPHABET_LENGTH;
import static ru.javarush.cryptoanalyzer.sternard.constant.language.English.FILE_EMPTY_ERROR;

public abstract class EncryptDecrypt implements doAction {

    protected final StringBuilder textOut = new StringBuilder();

    public String doEncryptDecrypt(String textIn, int key) {
        textOut.setLength(0);
        if (textIn.length() > 0) {
            for (int i = 0; i < textIn.length(); i++) {
                for (int j = 0; j < ALPHABET_LENGTH; j++) {
                    if (textIn.charAt(i) == ALPHABET[j]) {
                        resultEncryptDecrypt(j, key);
                    }
                }
            }
            return textOut.toString();
        } else {
            throw new HandlerExceptions(FILE_EMPTY_ERROR);
        }
    }

    protected abstract void resultEncryptDecrypt(int j, int key);
}
