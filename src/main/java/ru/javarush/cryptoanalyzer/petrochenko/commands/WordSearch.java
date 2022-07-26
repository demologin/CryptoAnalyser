package ru.javarush.cryptoanalyzer.petrochenko.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WordSearch {
    public String[] containsArray = {", ", ". ", "не ", "нет"};



    public boolean wordSearch(String string) throws IOException {
        Path path = Path.of(string);
        int count = 0;
        try {
            List<String> strings = Files.readAllLines(path);
            for (String s : strings) {
                //TODO Code style. Many warnings. Skip or fix it.
                for (int i = 0; i < containsArray.length; i++) {
                    String str = containsArray[i];
                    if (s.contains(str)){
                        count++;
                    }
                }
            }
           if (count>10) {
               return true;
           }
        } catch (IOException e) {
            throw new IOException(e);
        }


        return false;
    }
}
