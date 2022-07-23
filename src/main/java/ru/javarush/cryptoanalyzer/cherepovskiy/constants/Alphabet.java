package ru.javarush.cryptoanalyzer.cherepovskiy.constants;

import java.util.HashMap;
import java.util.Map;

public class Alphabet {
    private static final String rus = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final String symbols = ".-_,'\":-!? «»—;\n";
    private static final char[] CHARS = (rus.toLowerCase() + rus.toUpperCase() + symbols).toCharArray();
    public static final Map<Character, Integer> alphOriginal = new HashMap<>();

    static {
        for (int i = 0; i < CHARS.length; i++) {
            alphOriginal.put(CHARS[i], i);
        }
    }

}
