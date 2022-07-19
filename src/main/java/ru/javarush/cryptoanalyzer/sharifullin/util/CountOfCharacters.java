package ru.javarush.cryptoanalyzer.sharifullin.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static ru.javarush.cryptoanalyzer.sharifullin.costants.Strings.ALPHABET;

public class CountOfCharacters {

    char[] ALPHA = ALPHABET.toCharArray();
    public Map<Character, Integer> countOfChar(Path path) {

        HashMap<Character, Integer> qwe = new HashMap<>();

        String read;

        Map<Character, Integer> sortedMap;
        {
            try {
                read = Files.readString(path);
                char[] tt = read.toCharArray();

                for (int i = 0; i < ALPHA.length; i++) {
                    int count = 0;
                    for (int j = 0; j < tt.length; j++) {
                        int x = Character.compare(ALPHA[i], tt[j]);
                        if (x == 0) {
                            count++;
                        }
                        qwe.put(ALPHA[i], count);
                    }
                }

                sortedMap = qwe.entrySet().stream()
                        .sorted(Comparator.comparingInt(e -> e.getValue()))
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (a, b) -> {
                                    throw new AssertionError();
                                },
                                LinkedHashMap::new
                        ));
                System.out.println(sortedMap);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return sortedMap;

    }

}