package ru.javarush.cryptoanalyzer.afonin.util;

import java.util.*;


public class Analyser {
    private static final double MIN_SPACE_IN_1000_SYMBOLS = 130 / 1000d;

    public static boolean isText(List<String> analysedText){
        return getFrequencySymbols(analysedText).getOrDefault(' ', 0d) > MIN_SPACE_IN_1000_SYMBOLS;
    }

    public static Map<Character, Double> getFrequencySymbols(List<String> text){
        Map<Character, Double> result = new HashMap<>();
        text.stream()
                .map(String::toLowerCase)
                .flatMapToInt(String::chars)
                .mapToObj(i -> (char)i)
                .forEach(key -> result.put(key, result.getOrDefault(key, 0d) + 1));

        double sumAllSymbols = result.values().stream().mapToDouble(i -> i).sum();
        result.replaceAll((key, value) -> (value * 1000 / sumAllSymbols));
        return result;
    }

}
