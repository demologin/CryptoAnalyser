package ru.javarush.cryptoanalyzer.uzienko.commands;

import ru.javarush.cryptoanalyzer.uzienko.exceptions.ApplicationException;

import java.util.HashMap;
import java.util.Map;

public class CesarCharConverter {
    private final String alphabet;
    private int offset;
    private final Map<Character, Integer> alphabetMap;

    public CesarCharConverter(String alphabet, int offset) {
        this.alphabet = alphabet;
        if (alphabet.isEmpty()) {
            throw new ApplicationException("Alphabet can't be empty");
        }
        setOffset(offset);
        alphabetMap = of(alphabet);
    }

    public void setOffset(int offset) {
        this.offset = offset % alphabet.length();
    }

    private Map<Character, Integer> of(String alphabet) {
        Map<Character, Integer> result = new HashMap<>();
        char[] chars = alphabet.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            result.put(chars[i], i);
        }
        return result;
    }

    public Character convert(Character character) {
        Integer val = alphabetMap.get(character);
        return val == null ?
                character : alphabet.charAt((alphabet.length() + val + offset) % alphabet.length());
    }
}
