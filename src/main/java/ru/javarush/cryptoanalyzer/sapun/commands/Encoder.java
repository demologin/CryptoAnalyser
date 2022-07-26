package ru.javarush.cryptoanalyzer.sapun.commands;

import ru.javarush.cryptoanalyzer.sapun.entity.Result;
import ru.javarush.cryptoanalyzer.sapun.entity.ResultCode;
import ru.javarush.cryptoanalyzer.sapun.exception.ApplicationException;
import ru.javarush.cryptoanalyzer.sapun.util.PathFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static ru.javarush.cryptoanalyzer.sapun.constans.Strings.ALPHABET;

public class Encoder implements Action {

    @Override
    public Result execute(String[] parameters) {
        String txtFile = parameters[0];
        String encryptedFile = parameters[1];
        Path inputPath = Path.of(PathFinder.getRoot() + txtFile);
        try {
            List<String> strings = Files.readAllLines(inputPath);
            List<String> totalResult = new ArrayList<>();
            for (String string : strings) {
                char[] chars = string.toCharArray();
                char[] result = new char[chars.length];
                for (int i = 0; i < chars.length; i++) {
                    result[i] = encodeChar(chars[i]);
                }
                totalResult.add(new String(result));
            }

            Path outPath = Path.of(PathFinder.getRoot() + encryptedFile);
            Files.write(outPath, totalResult);
        } catch (IOException e) {
            throw new ApplicationException("IO error", e);
        }
        return new Result(ResultCode.OK, "read all bytes" + inputPath);
    }

    private char encodeChar(char element) {
        if (!ALPHABET.contains(String.valueOf(element))) {
            return element;
        }

        int index = ALPHABET.indexOf(element);
        int neededIndex = (index + KEY) % ALPHABET.length();
        return ALPHABET.charAt(neededIndex);
    }
}
