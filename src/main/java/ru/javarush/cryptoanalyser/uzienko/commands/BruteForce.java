package ru.javarush.cryptoanalyser.uzienko.commands;

import ru.javarush.cryptoanalyser.uzienko.constants.Strings;
import ru.javarush.cryptoanalyser.uzienko.entity.Result;
import ru.javarush.cryptoanalyser.uzienko.entity.ResultCode;
import ru.javarush.cryptoanalyser.uzienko.exceptions.ApplicationException;
import ru.javarush.cryptoanalyser.uzienko.util.PathFinder;

import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BruteForce implements Action {
    private final static String ALPHABET = Strings.ALPHABET;
    private final static int SAMPLE_TEXT_BUFFER_SIZE = 256;
    private final static CesarCharConverter cesarCharConverter = new CesarCharConverter(ALPHABET, 0);

    private final static String LOWERCASE_DOT_SPACE_UPPERCASE_PATTERN = "[а-яё]\\.\\s+[А-ЯЁ]";
    private final static Pattern pattern = Pattern.compile(LOWERCASE_DOT_SPACE_UPPERCASE_PATTERN);

    @Override
    public Result execute(String[] parameters) {
        int offset = findOffset(PathFinder.getRoot() + parameters[0]);
        Decoder decoder = new Decoder();
        decoder.execute(new String[]{parameters[0], parameters[1], String.valueOf(offset)});
        return new Result(ResultCode.OK, "brute force finished. offset=" + offset);
    }

    private int findOffset(String encryptedFile) {
        int maxScore = 0;
        int result = 0;
        String sample = getTextSample(encryptedFile);
        for (int i = 0; i < ALPHABET.length(); ++i) {
            int score = getScore(sample, -i);
            if (score > maxScore) {
                result = i;
                maxScore = score;
            }
        }
        return result;
    }

    private int getScore(String sample, int offset) {
        cesarCharConverter.setOffset(offset);
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < sample.length(); i++) {
            tmp.append(cesarCharConverter.convert(sample.charAt(i)));
        }
        Matcher matcher = pattern.matcher(tmp);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    private String getTextSample(String encryptedFile) {
        char[] result = new char[SAMPLE_TEXT_BUFFER_SIZE];
        try (FileReader fileReader = new FileReader(encryptedFile)) {
            if (fileReader.read(result) == -1) {
                throw new ApplicationException("Input file is empty");
            }
        } catch (IOException e) {
            throw new ApplicationException("IO error", e);
        }
        return String.valueOf(result);
    }
}
