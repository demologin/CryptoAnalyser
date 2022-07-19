package ru.javarush.cryptoanalyzer.osypenko.constants;

public class Alphabet {
    //TODO Coding. Need use private constructor in static context.
    private static final String RU = "йцукенгшщзхъфывапролджэячсмитьбю";
    private static final String EN = "qwertyuiopasdfghjklzxcvbnm";
    private static final String CH = "!?.,:;'-–+=*«„“»{}[]()/\\\" ";
    private static final String NUM = "0123456789";
    private static final byte BYTENUMBERJUMP = 10;
    public static final char JUMP = (char) BYTENUMBERJUMP;
    private static final String FULLALPHABET = EN.toUpperCase() + EN + JUMP + RU.toUpperCase() + RU + NUM + CH;
    public static char[] fullAlphabet = FULLALPHABET.toCharArray();
}