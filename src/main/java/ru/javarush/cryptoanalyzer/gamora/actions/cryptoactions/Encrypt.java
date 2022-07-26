package ru.javarush.cryptoanalyzer.gamora.actions.cryptoactions;
import ru.javarush.cryptoanalyzer.gamora.entity.Result;
import ru.javarush.cryptoanalyzer.gamora.entity.ResultCode;
import ru.javarush.cryptoanalyzer.gamora.util.PathFinder;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Encrypt extends AbstractCryptoAction {

    @Override
    public Result execute() {
        currentText = currentText.toLowerCase();
        String oldAlphabet = getTextAlphabet(currentText);
        map = getNewAlphabet(oldAlphabet);
        currentText = mapText(map);
        writeResult();
        return new Result(ResultCode.OK);
    }

    private Map<Character, Character> getNewAlphabet(String oldAlphabet) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < oldAlphabet.length(); i++) {
            char charAt = oldAlphabet.charAt(i);
            Character newChar = getNewChar(charAt);
            while (map.containsValue(newChar)) {
                newChar = getNewChar(charAt);
            }
            map.put(charAt, newChar);
        }
        return map;
    }

    private Character getNewChar(char charAt) {
        int newCharPosition = charAt + new Random().nextInt();
        return (Character) (char) newCharPosition;
    }
}
