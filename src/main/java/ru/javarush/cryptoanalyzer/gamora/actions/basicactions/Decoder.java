package ru.javarush.cryptoanalyzer.gamora.actions.basicactions;

import ru.javarush.cryptoanalyzer.gamora.actions.basicactions.textVerification.PunctuationTextVerification;
import ru.javarush.cryptoanalyzer.gamora.actions.basicactions.textVerification.SpellingTextVerification;
import ru.javarush.cryptoanalyzer.gamora.constants.Strings;
import ru.javarush.cryptoanalyzer.gamora.entity.Result;
import ru.javarush.cryptoanalyzer.gamora.entity.ResultCode;
import ru.javarush.cryptoanalyzer.gamora.exception.CryptoanalyzerApplicationException;
import ru.javarush.cryptoanalyzer.gamora.exception.ExceptionMessages;
import ru.javarush.cryptoanalyzer.gamora.util.PathFinder;

import java.util.Map;

public class Decoder extends AbstractAction {

    @Override
    public Result execute() {
        currentText = currentText.toLowerCase();
        if (key == 0) {
            decodeBrute();
        } else {
            decodeByKey();
        }
        writeResult();
        return new Result(ResultCode.OK);
    }

    private void decodeByKey() {
        Map<Character, Character> charMapping = getCharacterMapping(-key);
        currentText = mapText(charMapping);
    }

    private void decodeBrute() {
        for (int i = 1; i <= Strings.strings.ALPHABET.length(); i++) {
            Map<Character, Character> charMapping = getCharacterMapping(1);
            currentText = mapText(charMapping);
            if (verifyText(currentText)) {
                return;
            }
        }
        throw new CryptoanalyzerApplicationException(ExceptionMessages.BRUTE_FAILED.exceptionMessage);
    }

    private boolean verifyText(String text) {
        PunctuationTextVerification punctuationTextVerification = new PunctuationTextVerification();
        SpellingTextVerification spellingTextVerification = new SpellingTextVerification();
        return punctuationTextVerification.verify(text) && spellingTextVerification.verify(text);
    }

    public void build(String[] args) {
        readPath = PathFinder.pathFinder.getFilePath(args, 1);
        writePath = PathFinder.pathFinder.getFilePath(args, 2);
        currentText = readFromFile(readPath);
        if (args.length == 4) {
            key = Integer.parseInt(args[3]);
        }
    }
}
