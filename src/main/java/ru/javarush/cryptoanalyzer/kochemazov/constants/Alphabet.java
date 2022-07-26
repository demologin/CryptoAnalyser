package ru.javarush.cryptoanalyzer.kochemazov.constants;
public class Alphabet {
    private static final String RUSSIAN_ALPHABET_SMALL = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final String RUSSIAN_ALPHABET_BIG = RUSSIAN_ALPHABET_SMALL.toUpperCase(); // it's not use now, but in future,maybe
    private static final String ENGLISH_ALPHABET_SMALL = "abcdefghijklmnopqrstuvwxyz";
    private static final String ENGLISH_ALPHABET_BIG = ENGLISH_ALPHABET_SMALL.toUpperCase(); // it's not use now, but in future,maybe
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = ".,:;…—?!()<>{}[]«»/\"\"-+*&%$@=#";
    public static final String ALPHABET = RUSSIAN_ALPHABET_SMALL + ENGLISH_ALPHABET_SMALL;
    public static final String NUMBERS_SYMBOLS = NUMBERS + SYMBOLS;
}
