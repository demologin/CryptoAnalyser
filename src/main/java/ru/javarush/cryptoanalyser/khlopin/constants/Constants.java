package ru.javarush.cryptoanalyser.khlopin.constants;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Constants {
    private static final Path cryptText = Path.of("src\\text\\cryptText.txt");

    private static final Path text = Path.of("src\\text\\text.txt");

    private static final Path originalText = Path.of("src\\text\\originalText.txt");
    private static final List<Character> ALPHABET = Arrays.asList('а', 'б', 'в',
            'г', 'д', 'е', 'ё', 'ж', 'з', 'и','й','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э','ю', 'я', '.', ',', '«', '»',
            ':', '!', '?', ' ', '-', '—', '[',']');

    public static Path getOriginalText() {
        return originalText;
    }

    public static Path getText() {
        return text;
    }

    public static Path getCryptText() {
        return cryptText;
    }

    public static List<Character> getALPHABET() {
        return ALPHABET;
    }


}
