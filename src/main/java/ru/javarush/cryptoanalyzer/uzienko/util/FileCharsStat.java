package ru.javarush.cryptoanalyzer.uzienko.util;

import ru.javarush.cryptoanalyzer.uzienko.exceptions.ApplicationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileCharsStat {
    public static Map<Character, Double> of(String fileName) {
        Map<Character, Double> result = new HashMap<>();
        try (FileReader fileReader = new FileReader(fileName)) {
            //TODO Code style. Many warnings. Skip or fix it.
            int i = -1;
            int count = 0;
            while ((i = fileReader.read()) != -1) {
                Double d = result.get((char) i);
                result.put((char) i, d == null ? 1 : d + 1);
                count++;
            }
            double mid = count * 1. / result.size();
            for (Map.Entry<Character, Double> item : result.entrySet()) {
                Double dif = (item.getValue() - mid) / mid;
                item.setValue(dif * dif);
            }
        } catch (IOException e) {
            throw new ApplicationException("IO error " + fileName, e);
        }
        return result;
    }
}
