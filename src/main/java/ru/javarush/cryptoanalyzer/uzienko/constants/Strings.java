package ru.javarush.cryptoanalyzer.uzienko.constants;

public class Strings {
    private static final String rus = "абвгдеёжзиклмнопрстуфхцчшщъыьэюя";
    private static final String eng = "";
    private static final String cyphers = "1234567890";
    private static final String symbols = " .,«»:!?";
    public static final String ALPHABET = rus + rus.toUpperCase() + eng + eng.toUpperCase() + cyphers + symbols;
}
