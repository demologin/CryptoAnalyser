package ru.javarush.cryptoanalyzer.petrochenko.commands;

import ru.javarush.cryptoanalyzer.petrochenko.constants.Strings;
import ru.javarush.cryptoanalyzer.petrochenko.controller.Commands;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BroodForce {
    public BroodForce(String[] parameters) throws IOException {
        char[] alphabet = Strings.ALPHABET.toCharArray();
        //TODO Code style. Many warnings. Skip or fix it.
        Path pathFrom = Path.of(Commands.parameters[0]);
        //TODO Code style. Many warnings. Skip or fix it.
        Path pathTo = Path.of(Commands.parameters[1]);
        //TODO Code style. Many warnings. Skip or fix it.
        List<String> strings2 = new ArrayList<>();
        try {
            WordSearch wordSearch = new WordSearch();
            for (int i = 0; i < alphabet.length; i++) {
                parameters[2] = String.valueOf(i);
                DecoderOne decoderOne = new DecoderOne(parameters);
                boolean bool  = wordSearch.wordSearch(parameters[1]);
                if(bool) break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

       // System.out.println(Messeges.ooperationCompleted);
    }
}