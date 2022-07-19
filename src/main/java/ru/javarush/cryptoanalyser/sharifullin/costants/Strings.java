package ru.javarush.cryptoanalyser.sharifullin.costants;

public class Strings {
    private static final String rus = "ячсмитьбюэждлорпавыфйцукенгшщзхъё";
    private static final String cyphers = "1234567890";
    private static final String symbols = "\n!@:;.,]['#$%^&*()_-–? ";
    public static final String ALPHABET = rus + rus.toUpperCase() + cyphers
            + cyphers.toUpperCase() + symbols;
}
