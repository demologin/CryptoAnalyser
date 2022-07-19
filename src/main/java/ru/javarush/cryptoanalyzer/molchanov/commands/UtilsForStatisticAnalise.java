package ru.javarush.cryptoanalyzer.molchanov.commands;

import ru.javarush.cryptoanalyzer.molchanov.constants.Strings;
import ru.javarush.cryptoanalyzer.molchanov.util.TextUtilMethods;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UtilsForStatisticAnalise {
    public static HashMap<Character, Double> textAnalise(Character[] text) {
        HashMap<Character, Double> statisticOfLettersInText = TextUtilMethods.AlphabetToHashMap(Strings.alphabet);
        for (Map.Entry<Character, Double> entry: statisticOfLettersInText.entrySet()) {
            Character target = entry.getKey();
            int countOfTarget = 0;
            for (Character c: text) {

                if(Character.toLowerCase(c) == Character.toLowerCase(target)) countOfTarget++;
            }
            statisticOfLettersInText.put(target, TextUtilMethods.round(countOfTarget*1.0/text.length*100, 3));
        }
        return statisticOfLettersInText;
    }
    private static Character getKeyWithMaxValue (HashMap<Character, Double> map){
        Double max = 0.0;
        Map.Entry<Character, Double> targetEntry = null;
        for (Map.Entry<Character, Double> ent: map.entrySet()) {
            if(ent.getValue() > max) {
                max = ent.getValue();
                targetEntry = ent;
            }
        }
        return targetEntry.getKey();
    }
    public static String statDecoderIt1 (char[] encodedText, HashMap<Character, Double> encodStat, HashMap<Character, Double> analiseStat){
        char[] copyOfEncodedText = Arrays.copyOf(encodedText, encodedText.length);
        int step = 0;
        while(encodStat.size() > 1){
            System.out.println(++step);
            Character keyFromEncod = getKeyWithMaxValue(encodStat);
            Character keyFromStat = getKeyWithMaxValue(analiseStat);
            System.out.println(keyFromEncod +"="+ encodStat.get(keyFromEncod) + " "
                    + keyFromStat +"="+ analiseStat.get(keyFromStat));
            for (int i = 0; i < copyOfEncodedText.length; i++) {
                if(copyOfEncodedText[i] == keyFromEncod){
                    encodedText[i] = keyFromStat;
                }
            }
            encodStat.remove(keyFromEncod);
            analiseStat.remove(keyFromStat);
        }
        return new String(encodedText);
    }
}
