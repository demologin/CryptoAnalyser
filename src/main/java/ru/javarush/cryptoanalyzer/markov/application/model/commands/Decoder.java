package ru.javarush.cryptoanalyzer.markov.application.model.commands;


import ru.javarush.cryptoanalyzer.markov.application.model.entity.Result;
import ru.javarush.cryptoanalyzer.markov.application.model.entity.ResultCode;

import java.util.ArrayList;
import java.util.List;

 class Decoder extends GeneralLogic implements Action{

    @Override
    public Result execute(int key, List<Character> text) {
        List<Character> result = new ArrayList<>(text.size());
        if(isCorrectKey(key)) {
            return new Result(ResultCode.ERROR, "Illegal kay!");
        }
        for (Character character : text) {
            int encrypted = character;
            char deciphered = (char)(encrypted - key);
            if(findCharacterInAlphabet(deciphered) != -1) {
                result.add(deciphered);
            } else {
                result.add((char)encrypted);
            }
        }
        return new Result(ResultCode.OK, "Text transcribed!", result);
    }

}
