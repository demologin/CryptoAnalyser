package ru.javarush.cryptoanalyser.sternard.constant;

public class Alphabet {
    private static final String RUS = "абвгдежзийклмнопрстуфхцчшщъыьэюя";
    private static final String ENG = "abcdefghijklmnopqrstuvwxyz";
    //    private final static String SYMBOLS = ".,«»\"':!? \n";
    private static final String SYMBOLS = "«»,./?><'\":;][{}\\|!@#$%^&*()`~_-–+= \n";
    private static final String NUMBERS = "0123456789";
    private final static String ALPHABET_CONCAT = RUS + RUS.toUpperCase() + SYMBOLS + NUMBERS + ENG + ENG.toUpperCase();
    public final static char[] ALPHABET = ALPHABET_CONCAT.toCharArray();
    public final static int ALPHABET_LENGTH = ALPHABET.length - 1;
}