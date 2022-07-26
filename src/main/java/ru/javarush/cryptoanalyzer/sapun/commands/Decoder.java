package ru.javarush.cryptoanalyzer.sapun.commands;

import ru.javarush.cryptoanalyzer.sapun.entity.Result;
import ru.javarush.cryptoanalyzer.sapun.exception.ApplicationException;
import ru.javarush.cryptoanalyzer.sapun.util.PathFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static ru.javarush.cryptoanalyzer.sapun.constans.Strings.ALPHABET;
import static ru.javarush.cryptoanalyzer.sapun.entity.ResultCode.OK;

public class Decoder implements Action{
    @Override
    public Result execute(String[] parameters) {
        String encryptedFile = parameters[0];
        String outFile = parameters[1];
        Path inputPath = Path.of(PathFinder.getRoot() + encryptedFile);
        try {
            List<String> strings = Files.readAllLines(inputPath);
            List<String> totalResult = new ArrayList<>();
            for (String string : strings) {
                char[] chars = string.toCharArray();
                char[] result = new char[chars.length];
                for (int i = 0; i < chars.length; i++) {
                    result[i] = decodeChar(chars[i]);
                }
                totalResult.add(new String(result));
            }

            Path outPath = Path.of(PathFinder.getRoot() + outFile);
            Files.write(outPath, totalResult);
        } catch (IOException e) {
            throw new ApplicationException("IO error", e);
        }

        return new Result(OK, "decode all from file: " + inputPath);
    }
    private char decodeChar(char element) {
        if (!ALPHABET.contains(String.valueOf(element))) {
            return element;
        }

        int index = ALPHABET.indexOf(element);
        int neededIndex = (index - KEY);
        while (neededIndex < 0){
            neededIndex += ALPHABET.length();
        }
        return ALPHABET.charAt(neededIndex);
    }
}
