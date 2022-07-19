package ru.javarush.cryptoanalyser.kislyakova.constants;

public class CipherConstants {
    public static final String RUS_CAPITAL_LETTER = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    public static final String RUS_SMALL_LETTER = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    public static final int ALPHABET_RUS_LENGTH = RUS_CAPITAL_LETTER.length();

    public static final char[] PUNCTUATION_CHAR_ARRAY = {'(', '.', ',', '”', 'ʼ', ':', '-', '!', '?', ' ', ')'};
    public static final int PUNCTUATION_LENGTH = PUNCTUATION_CHAR_ARRAY.length;

    public static final double[] RUS_LETTERS_PROBABILITIES = {0.0801, 0.0159, 0.0454, 0.0170, 0.0298, 0.0845, 0.0004, 0.0940, 0.0165, //абвгдеёжз
            0.0735, 0.0121, 0.0349, 0.0440, 0.0321, 0.0670, 0.1097, 0.0281, 0.0473, //ийклмнопр
            0.0547, 0.0626, 0.0262, 0.0026, 0.0097, 0.0048, 0.0144, 0.0073, 0.0036, //стуфхцчшщ
            0.0004, 0.0190, 0.0174, 0.0032, 0.0064, 0.0201}; //ъыьэюя
}
