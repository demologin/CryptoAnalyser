package ru.javarush.cryptoanalyzer.markov.application.model.commands;

import ru.javarush.cryptoanalyzer.markov.application.util.Alphabet;

abstract class GeneralLogic {
    //TODO Coding. Magic values or methods. Bad reading and understanding
    protected boolean isCorrectKey(int key) {
        return key <= 0 || key > 32;
    }

    protected int findCharacterInAlphabet(char symbol) {
        char[] alphabet = Alphabet.getRussianAlphabet();
        int result = -1;
        for (char c : alphabet) {
            if (c == symbol) {
                result = symbol;
                break;
            }
        }
        return result;
    }

}
