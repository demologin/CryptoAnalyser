package ru.javarush.cryptoanalyzer.petrochenko.constants;

import java.util.HashMap;
import java.util.Map;

public class Strings {
    private static final String rus = "абвгдеёжзийклмнопрстуфхцчшщьыъэюя";
    private static final String cyphers = "1234567890";
    private static final String symbols = ",./:@'!_-=+`;][{} &*|%#?";
    public static String ALPHABET = rus + cyphers + symbols;
    public char[] alphabet = ALPHABET.toCharArray();

    public Map<Character, Integer> getAlphabetMap(char[] chars) {
        Map<Character, Integer> map = new HashMap<>();
        chars = alphabet;
        //TODO Code style. Many warnings. Skip or fix it.
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], 0);
        }
        return map;
    }


}
