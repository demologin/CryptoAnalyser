package ru.javarush.cryptoanalyzer.afonin.constans;

public class BaseAlphabet {
    private static final String RUS = "абвгдёежзийклмнопрстуфхцчшщъыьэюя";

    private static final String CYPHERS = "1234567890";

    private static final String SYMBOLS = ".,«»\"\\:!?- ";

    public static final char[] ALPHABET = (RUS + CYPHERS + SYMBOLS).toCharArray();

}
