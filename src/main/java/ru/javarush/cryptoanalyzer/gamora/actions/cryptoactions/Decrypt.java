package ru.javarush.cryptoanalyzer.gamora.actions.cryptoactions;

import ru.javarush.cryptoanalyzer.gamora.actions.cryptoactions.analysis.CharacterFrequencyAnalyzer;
import ru.javarush.cryptoanalyzer.gamora.entity.Result;
import ru.javarush.cryptoanalyzer.gamora.entity.ResultCode;
import ru.javarush.cryptoanalyzer.gamora.util.PathFinder;

import java.nio.file.Path;
import java.util.*;

public class Decrypt extends AbstractCryptoAction {
    private Path examplePath;
    private String exampleText;

    @Override
    public Result execute() {
        map = getCharacterMapping();
        currentText = mapText(map);
        writeResult();
        return new Result(ResultCode.OK);
    }

    @Override
    public void build(String[] args) {
        super.build(args);
        currentText = currentText.toLowerCase();
        examplePath = PathFinder.pathFinder.getFilePath(args[3]);
        exampleText = readFromFile(examplePath).toLowerCase();
    }

    private Map<Character, Character> getCharacterMapping() {
        Map<Character, Character> characterMap = new HashMap<>();
        List<Map.Entry<Character, Double>> textFrequencies = getTextSortedCharacterFrequencies(currentText);
        List<Map.Entry<Character, Double>> exampleTextFrequencies = getTextSortedCharacterFrequencies(exampleText);
        int alphabetLength = Math.min(textFrequencies.size(), exampleTextFrequencies.size());
        for (int i = 0; i < alphabetLength; i++) {
            characterMap.put(textFrequencies.get(i).getKey(), exampleTextFrequencies.get(i).getKey());
        }
        return characterMap;
    }

    private List<Map.Entry<Character, Double>> getTextSortedCharacterFrequencies (String text) {
        return CharacterFrequencyAnalyzer.analyzer.sortedCharacterFrequencies(text, getTextAlphabet(text));
    }
}
