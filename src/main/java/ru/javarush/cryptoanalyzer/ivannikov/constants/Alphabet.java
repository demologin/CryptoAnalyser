package ru.javarush.cryptoanalyzer.ivannikov.constants;

public class Alphabet {
    //TODO Coding. Need use private constructor in static context.
    private static final String rus = "йцукенгшщзхъфывапролджэячсмитьбюё";
    private static final String symbols = "/*-+.,/[]{}:;'()%#!? \n";
    private static final String cyphers = "1234567890";


    public static final String ALPHABET = rus+symbols;
}
