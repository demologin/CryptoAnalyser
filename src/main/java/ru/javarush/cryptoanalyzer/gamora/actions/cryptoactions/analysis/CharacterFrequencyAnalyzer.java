package ru.javarush.cryptoanalyzer.gamora.actions.cryptoactions.analysis;

import java.util.*;

public class CharacterFrequencyAnalyzer {
    public static CharacterFrequencyAnalyzer analyzer = new CharacterFrequencyAnalyzer();

    private CharacterFrequencyAnalyzer() {
    }

    private Map<Character, Double> getCharacterFrequencies (String text, String alphabet) {
        Map<Character, Double> characterFrequencyTreeMap = new HashMap<>();
        for (Character character : alphabet.toCharArray()) {
            Double characterFrequency = getCharacterFrequency(text, character);
            characterFrequencyTreeMap.put(character, characterFrequency);
        }
        return characterFrequencyTreeMap;
    }

    private Double getCharacterFrequency(String text, Character character) {
        double count = text.chars().filter(ch -> ch == character).count();
        return count/(double)text.length();
    }

    public List<Map.Entry<Character, Double>> sortedCharacterFrequencies (String text, String alphabet) {
        Map<Character, Double> characterFrequencies = getCharacterFrequencies(text, alphabet);
        List<Map.Entry<Character, Double>> list = new ArrayList<>(characterFrequencies.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Collections.reverse(list);

        return list;
    }
}
