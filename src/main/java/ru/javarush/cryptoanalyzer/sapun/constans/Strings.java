package ru.javarush.cryptoanalyzer.sapun.constans;

public class Strings {
    //TODO Coding. Need use private constructor in static context.
    private static final String ru = "йцукенгшщзхъфывапролджэячсмитьбю";
    private static final String eng = "qwertyuiopasdfghjklzxcvbnm";
    private static final String numbers = "1234567890";
    private static final String symbols = ",./`!@#$%^&*)(_-=+}{]['";
    public static final String ALPHABET = ru + ru.toUpperCase() + eng + eng.toUpperCase() + numbers + symbols;

}
