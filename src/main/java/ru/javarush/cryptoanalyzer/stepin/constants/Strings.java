package ru.javarush.cryptoanalyzer.stepin.constants;

public class Strings {
    public static final String ALPHABET = "йцукенгшщзхъфывапролджэячсмитьбю" + "ЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮ" +
            ".,\":-–!? +-*/\\@#$%^<>&(){}[];'|`=_©«»—0123456789";

    public static int alphabetLength() {
        return ALPHABET.length();
    }

}
