package ru.javarush.cryptoanalyzer.sapun.commands;

import ru.javarush.cryptoanalyzer.sapun.entity.Result;
import ru.javarush.cryptoanalyzer.sapun.entity.ResultCode;
import ru.javarush.cryptoanalyzer.sapun.util.PathFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static java.util.Objects.isNull;
import static ru.javarush.cryptoanalyzer.sapun.constans.Strings.ALPHABET;

public class StatisticAnalysis implements Action {
    @Override
    public Result execute(String[] parameters) {
        String encodedFile = parameters[0];
        String dictionaryFile = parameters[1];
        String outFile = parameters[2];
        //TODO Coding. Magic values or methods. Bad reading and understanding
        Path inputPath = Path.of(PathFinder.getRoot() + "statistic/" + encodedFile);
        Path dictionaryPath = Path.of(PathFinder.getRoot() + "statistic/" + dictionaryFile);
        Path outPath = Path.of(PathFinder.getRoot() + "statistic/" + outFile);

        try {
            String input = Files.readString(inputPath);
            String dictionary = Files.readString(dictionaryPath);

            List<Character> inputList = calculateStatistic(input);
            List<Character> dictionaryList = calculateStatistic(dictionary);
            //TODO Code style. Many warnings. Skip or fix it.
            String result = new String(input);
            for (int i = 0; i < inputList.size(); i++) {
                Character replaceFrom = inputList.get(i);
                Character replaceTo = dictionaryList.get(i);
                result = result.replace(replaceFrom, replaceTo);
            }

            Files.write(outPath, Collections.singleton(result));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return new Result(ResultCode.OK, "read all code");
    }

    private List<Character> calculateStatistic(String input) {
        Map<Character, Long> dictionary = new HashMap<>();
        char[] letters = input.toCharArray();
        for (char letter : letters) {
            if (!ALPHABET.contains(String.valueOf(letter))) {
                continue;
            }
            Long currentValue = dictionary.get(letter);
            long value = isNull(currentValue) ? 1 : currentValue + 1;
            dictionary.put(letter, value);
        }

        List<Long> values = new ArrayList<>(dictionary.values());
        values.sort(Comparator.reverseOrder());

        List<Character> result = new ArrayList<>();
        for (long value : values) {
            Set<Map.Entry<Character, Long>> entries = dictionary.entrySet();
            for (Map.Entry<Character, Long> entry : entries) {
                if (value == entry.getValue()) {
                    result.add(entry.getKey());
                    break;
                }
            }
        }

        return result;
    }

}
