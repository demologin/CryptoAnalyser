package ru.javarush.cryptoanalyzer.molchanov.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class TextUtilMethods {
    public static char[] textInCharArray (List<String> allLines){
        StringBuilder s = new StringBuilder();
        for (String str : allLines) {
            s.append(str).append("\n");
        }
        char[] allSymbolsInText = new char[s.length()];
        s.getChars(0, s.length(), allSymbolsInText, 0);

        return allSymbolsInText;
    }

    public static HashMap<Character, Double> AlphabetToHashMap (Character[] alphabet){
        HashMap<Character, Double> alphabetCharWithCount = new HashMap<>();
        for (Character character : alphabet) {
            alphabetCharWithCount.put(character, 0.0);
        }
        return alphabetCharWithCount;
    }

    public static Character[] charToCharacterArray(char[] arr){
        Character[] ch = new Character[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ch[i] = arr[i];
        }
        return ch;
    }
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
