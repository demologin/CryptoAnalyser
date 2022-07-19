package ru.javarush.cryptoanalyser.molchanov.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class Strings {
    public static final Character[] alphabet = new Character[]{'а','б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н',
            'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю' ,
            'я', '.', ',', '«', '»', ':', '—', '!', '?', '\'', ' '};
    public static final ArrayList<Character> ALPHABET = new ArrayList<>(Arrays.asList(alphabet));

    public static String[] decod = {"или ", "что", "как", "он", "ты", "она", "вы", "мы", "они", "их", ", ", ".\n" };
}
