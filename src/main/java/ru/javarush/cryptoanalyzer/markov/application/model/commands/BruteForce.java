package ru.javarush.cryptoanalyzer.markov.application.model.commands;


import ru.javarush.cryptoanalyzer.markov.application.model.entity.Result;
import ru.javarush.cryptoanalyzer.markov.application.model.entity.ResultCode;
import ru.javarush.cryptoanalyzer.markov.application.util.Alphabet;

import java.util.ArrayList;
import java.util.List;

 class BruteForce implements Action{

    @Override
    public Result execute(int key, List<Character> text) {
        List<Character> partOfText = getPartOfText(text);
        Decoder decoder = new Decoder();
        Result result = new Result(ResultCode.ERROR, " ");
        for(int i = key; i < 32; i++) {
            if(isEncoded((decoder.execute(i,partOfText).getText()))) {
                return decoder.execute(i, text);
            }
        }
        return result;
    }

    private List<Character> getPartOfText(List<Character> text) {
        List<Character> partOfText = new ArrayList<>(30);
        for (int i = 0; i < 30; i++) {
            partOfText.add(text.get(i));
        }
        return partOfText;
    }

    private boolean isEncoded(List<Character> text) {
        boolean result = false;
        for (Character character : text) {
            if (character == Alphabet.getSymbol()) {
                result = true;
                break;
            }
        }
        return result;
    }

}
