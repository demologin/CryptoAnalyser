package ru.javarush.cryptoanalyzer.belitsky.alphabet;


import java.util.Arrays;
import java.util.List;

public class Alphabet {//алфавит и разновидности блоков символов для проверок etc.
    //TODO Code style. Use Russian comments? Bad English is much better than the best Russian comments.
    private static final List<Character> ALPHABET = Arrays.asList('а', 'б', 'в',
            'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»',
            ':', '!', '?', ' ');
    private static final List<Character> SYMBOLS_TO_CHECK = Arrays.asList(',', ':');
    private static final List<Character> SYMBOLS = Arrays.asList('.', ',', '«', '»', ':', '!', '?');
    private static final List<Character> LETTERS = Arrays.asList('а', 'б', 'в',
            'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

    public static char get(int index) {
        return ALPHABET.get(index);
    }

    public static int indexOf(char symbol) {
        return ALPHABET.indexOf(symbol);
    }

    public static boolean alphabetContainsCheck(char character) {
        return ALPHABET.contains(character);
    }

    public static int getSize() {
        return ALPHABET.size();
    }

    public static boolean symbolsToCheckContainCheck(char character) {
        return SYMBOLS_TO_CHECK.contains(character);
    }

    public static boolean lettersContainCheck(char character) {
        return LETTERS.contains(character);
    }

    //TODO Code style. Many warnings. Skip or fix it.
    public static boolean symbolsContainCheck(char character) {
        return SYMBOLS.contains(character);
    }

    public static boolean yodle(char character) {
        return (character == 'ъ' || character == 'ы' || character == 'ь');
    }
}
