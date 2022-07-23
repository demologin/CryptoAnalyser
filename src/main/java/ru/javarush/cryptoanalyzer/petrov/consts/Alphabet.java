package ru.javarush.cryptoanalyzer.petrov.consts;

import java.util.Locale;

public class Alphabet {
    public static  int[] correctCharacters;
    static {
        String punctuationSymbvol = " !\",.:?()";
        String russianLater = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        String englishLater = "abcdefghijklmnopqrstuvwxyz";
        String degit = "0123456789";
        String allChars = punctuationSymbvol + russianLater +
                russianLater.toUpperCase(Locale.ROOT) +
                englishLater +
                englishLater.toUpperCase(Locale.ROOT) +
                degit;
        correctCharacters = new int[allChars.length()];
        for(int i = 0; i < allChars.length(); i++){
            correctCharacters[i] = allChars.charAt(i);
        }
    }


}