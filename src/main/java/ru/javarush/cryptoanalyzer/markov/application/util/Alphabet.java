package ru.javarush.cryptoanalyzer.markov.application.util;

public class Alphabet {

    private Alphabet() {

    }

    private static final char[] russianAlphabet = {' ', '.', ',',  '”', '”', ':', '-', '!', '?', 'а', 'А',
            'б', 'Б', 'в', 'В', 'г', 'Г', 'д', 'Д', 'е', 'Е', 'ё', 'Ё', 'ж', 'Ж', 'з', 'З', 'и', 'И', 'й', 'Й',
            'к', 'К', 'л', 'Л', 'м', 'М', 'н', 'Н', 'о', 'О', 'п', 'П', 'р', 'Р', 'с', 'С', 'т', 'Т', 'у', 'У',
            'ф', 'Ф', 'х', 'Х', 'ц', 'Ц', 'ч', 'Ч', 'ш', 'Ш', 'щ', 'Щ', 'ъ', 'Ъ', 'ы', 'Ы', 'ь', 'Ь', 'э', 'Э',
            'ю', 'Ю', 'я', 'Я', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static char[] getRussianAlphabet() {
        return russianAlphabet;
    }

    public static char getSymbol() {
        return russianAlphabet[0];
    }
}
