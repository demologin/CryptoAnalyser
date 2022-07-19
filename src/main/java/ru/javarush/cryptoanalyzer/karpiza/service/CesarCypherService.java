package ru.javarush.cryptoanalyzer.karpiza.service;

import org.springframework.stereotype.Service;

@Service
public class CesarCypherService {

    public static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п',
            'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', 'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё',
            'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь',
            'Э', 'Ю', 'Я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ', '\n', '-', '(', ')', '0', '1', '2', '3', '4',
            '5', '6', '7', '8', '9'};

    public String encryption(String source, int key) {
        char[] charSource = source.toCharArray();
        char[] newCharSource = new char[charSource.length];

        for (int i = 0; i < charSource.length; i ++) {
            for (int a = 0; a < ALPHABET.length ; a++) {
                if (charSource[i] == ALPHABET[a]) {
                    int newOrder = (a + key) % ALPHABET.length;
                    newCharSource[i] = ALPHABET[newOrder];
                }
            }
        }

        String result = new String(newCharSource);

        return result;
    }

    public String decryption(String source, int key) {
        char[] charSource = source.toCharArray();
        char[] newCharSource = new char[charSource.length];

        for (int i = 0; i < charSource.length; i ++) {
            for (int a = 0; a < ALPHABET.length ; a++) {
                if (charSource[i] == ALPHABET[a]) {
                    int newOrder = (a + ALPHABET.length - key) % ALPHABET.length;
                    newCharSource[i] = ALPHABET[newOrder];
                }
            }
        }

        String result = new String(newCharSource);

        return result;
    }

}
