package ru.javarush.cryptoanalyzer.markov.application.model.commands;



import ru.javarush.cryptoanalyzer.markov.application.model.entity.Result;
import ru.javarush.cryptoanalyzer.markov.application.model.entity.ResultCode;

import java.util.ArrayList;
import java.util.List;

 class Encoder extends GeneralLogic implements Action {

    @Override
    public Result execute(int key, List<Character> text) {
        ArrayList<Character> result = new ArrayList<>(text.size());
        if(isCorrectKey(key)) {
            return new Result(ResultCode.ERROR, "Illegal kay!");
        }
        for (Character integer : text) {
            char original = integer;
            int searchResult = findCharacterInAlphabet(original);
            if (searchResult == -1) {
                result.add(original);
            } else {
                result.add((char)(searchResult+key));
            }
        }
        return new Result(ResultCode.OK, "Text successfully encoded!", result);
    }

}
