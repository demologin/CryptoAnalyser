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

public class BrutForce implements Action {
    @Override
    public Result execute(String[] parameters) {
        String encryptedFile = parameters[0];
        Path inputPath = Path.of(PathFinder.getRoot() + encryptedFile);
        try {
            List<String> strings = Files.readAllLines(inputPath);
            for (int key = 0; key < ALPHABET.length(); key++) {
                List<String> totalResult = new ArrayList<>();
                for (String string : strings) {
                    char[] chars = string.toCharArray();
                    char[] result = new char[chars.length];
                    for (int i = 0; i < chars.length; i++) {
                        result[i] = decodeChar(chars[i], key);
                    }
                    totalResult.add(new String(result));
                }

                if (isDecodedCorrect(totalResult)) {
                    Path outPath = Path.of(PathFinder.getRoot() + key + ".txt");
                    Files.write(outPath, totalResult);
                    break;
                }
            }
        } catch (IOException e) {
            throw new ApplicationException("IO error", e);
        }

        return new Result(OK, "decode all from file: " + inputPath);
    }
    private char decodeChar(char element, int key) {
        if (!ALPHABET.contains(String.valueOf(element))) {
            return element;
        }

        int index = ALPHABET.indexOf(element);
        int neededIndex = (index - key);
        while (neededIndex < 0){
            neededIndex += ALPHABET.length();
        }
        return ALPHABET.charAt(neededIndex);
    }

    private boolean isDecodedCorrect(List<String> lines) {
        String marker = "день";

        StringBuilder buffer = new StringBuilder();
        for (String line : lines) {
            buffer.append(line);
        }

        return buffer.toString().contains(marker);
    }
}
