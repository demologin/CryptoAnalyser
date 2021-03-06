package ru.javarush.cryptoanalyzer.rantsev.commands;

import ru.javarush.cryptoanalyzer.rantsev.entity.Result;
import ru.javarush.cryptoanalyzer.rantsev.entity.ResultCode;
import ru.javarush.cryptoanalyzer.rantsev.utility.PathFinder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Analyse implements Action {
    private final Map<Integer, Character> statistic = new TreeMap<>();
    private final TreeMap <Integer, Character> source = new TreeMap<>();

    @Override
    public void execute(String[] parameters) {
        String analyzer="123";
        String root = PathFinder.getRoot();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(root + parameters[1]))) {
            String sourceText = Files.readString(Paths.get(root + parameters[0]));
            char[] chars = sourceText
                    .toLowerCase()
                    .toCharArray();
            int count;
                for (char aChar : chars) {
                    count = 0;
                    for (char c : chars) {
                        if (aChar == c) {
                            count += 1;
                        }
                    }
                    if (source.size() < 44) {
                        source.put(count, aChar);
                    }
                }
                getStatistic();
                List<Map.Entry<Integer, Character>> sourceArray = new ArrayList<>(source.entrySet());
            List<Map.Entry<Integer, Character>> statisticArray = new ArrayList<>(statistic.entrySet());

            Map<Integer, Character> analyse = new TreeMap<>();
            for (int i = 0; i < sourceArray.size() && i < statisticArray.size(); i++) {
                analyse.put(sourceArray.get(i).getKey(), statisticArray.get(i).getValue());
            }

            for (int keySource: source.keySet()) {
                char sourceSymbol = source.get(keySource);
                for (int keyAnalyse: analyse.keySet()) {
                    char analyseSymbol = analyse.get(keyAnalyse);
                    for (int i = 0; i < chars.length; i++) {
                        if (sourceSymbol == chars[i] && keySource == keyAnalyse) {
                            chars[i] = analyseSymbol;
                        }
                    }
                }
            }
            writer.write(new String(chars));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        new Result(ResultCode.OK, "File is ready");
    }
    void getStatistic() {
        statistic.put(0, ')');
        statistic.put(1, ':');
        statistic.put(2, '"');
        statistic.put(3, '??');
        statistic.put(4, '??');
        statistic.put(5, '???');
        statistic.put(6, '?');
        statistic.put(7, '??');
        statistic.put(8, '!');
        statistic.put(9, '??');
        statistic.put(10, '-');
        statistic.put(11, '??');
        statistic.put(12, '??');
        statistic.put(13, '??');
        statistic.put(14, '??');
        statistic.put(15, '??');
        statistic.put(16, '??');
        statistic.put(17, '-');
        statistic.put(18, '??');
        statistic.put(19, '.');
        statistic.put(20, '\t');
        statistic.put(21, '??');
        statistic.put(22, '??');
        statistic.put(23, '??');
        statistic.put(24, '??');
        statistic.put(25, ',');
        statistic.put(26, '??');
        statistic.put(27, '??');
        statistic.put(28, '??');
        statistic.put(29, '??');
        statistic.put(30, '??');
        statistic.put(31, '??');
        statistic.put(32, '??');
        statistic.put(33, '??');
        statistic.put(34, '??');
        statistic.put(35, '??');
        statistic.put(36, '??');
        statistic.put(37, '??');
        statistic.put(38, '??');
        statistic.put(39, '??');
        statistic.put(40, '??');
        statistic.put(41, '??');
        statistic.put(42, '??');
        statistic.put(43, ' ');
    }
}
