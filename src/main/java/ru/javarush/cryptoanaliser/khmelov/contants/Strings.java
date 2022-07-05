package ru.javarush.cryptoanaliser.khmelov.contants;

public class Strings {
    private static final String rus = "йцукенгшщзэхъждлорпавыфячсмитьбю";
    private static final String eng = "qwertyuioplkjhgfdsazxcvbnm";
    private static final String cyphers = "1234567890";
    private static final String symbols = ",./@'!_-=+';][{}";
    public static final String ALPHABET = rus + rus.toUpperCase() + eng + eng.toUpperCase() + cyphers + symbols;
}
