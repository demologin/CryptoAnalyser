package ru.javarush.cryptoanalyzer.uzienko.commands;

import ru.javarush.cryptoanalyzer.uzienko.entity.Result;
import ru.javarush.cryptoanalyzer.uzienko.entity.ResultCode;
import ru.javarush.cryptoanalyzer.uzienko.exceptions.ApplicationException;
import ru.javarush.cryptoanalyzer.uzienko.util.FileCharsStat;
import ru.javarush.cryptoanalyzer.uzienko.util.PathFinder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class StatisticalDecoder implements Action {
    @Override
    public Result execute(String[] parameters) {
        String encryptedFileName = PathFinder.getRoot() + parameters[0];
        String sourceFileName = PathFinder.getRoot() + parameters[1];
        String resultFileName = PathFinder.getRoot() + parameters[2];

        Map<Character, Double> encryptedStat = FileCharsStat.of(encryptedFileName);
        Map<Character, Double> sourceStat = FileCharsStat.of(sourceFileName);

        List<Map.Entry<Character, Double>> sourceByRate = new ArrayList<>(sourceStat.entrySet());
        List<Map.Entry<Character, Double>> encryptedByRate = new ArrayList<>(encryptedStat.entrySet());

        sourceByRate.sort((a, b) -> -Double.compare(a.getValue(), b.getValue()));
        encryptedByRate.sort((a, b) -> -Double.compare(a.getValue(), b.getValue()));

        Map<Character, Character> mapMap = new HashMap<>();
        for (int i = 0; i < sourceByRate.size() && i < encryptedByRate.size(); ++i) {
            mapMap.put(encryptedByRate.get(i).getKey(), sourceByRate.get(i).getKey());
        }

        try (FileReader fileReader = new FileReader(encryptedFileName);
             FileWriter fileWriter = new FileWriter(resultFileName)) {
            for (int i = fileReader.read(); i > 0; i = fileReader.read()) {
                Character c = mapMap.get((char) i);
                fileWriter.write(c == null ? (char) i : c);
            }
        } catch (IOException e) {
            throw new ApplicationException("IO error", e);
        }
        return new Result(ResultCode.OK, "read all bytes from " + encryptedFileName);
    }
}
