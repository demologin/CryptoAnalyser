package ru.javarush.cryptoanalyzer.bogdanov.comands;

import ru.javarush.cryptoanalyzer.bogdanov.constants.Strings;
import ru.javarush.cryptoanalyzer.bogdanov.entity.Result;
import ru.javarush.cryptoanalyzer.bogdanov.entity.ResultCode;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Decoder implements Action {
    @Override
    public Result execute(String[] parameters) {
        //TODO Code style. Long code. Needs to be split into several methods
        Path path = Paths.get(parameters[1]);
        Path path2 = Paths.get(parameters[0]);
        StringBuilder stringBuilder = new StringBuilder();
        byte[] bytes;
        try {
            bytes = Files.readAllBytes(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String str1 = new String(bytes, StandardCharsets.UTF_8);

        int count = Integer.parseInt(parameters[2]);
        int countPrest = 100;
        char[] alphubet = Strings.rus.toCharArray();
        char[] alphubetTop = Strings.rus.toUpperCase().toCharArray();
        char[] alphubetEng = Strings.eng.toCharArray();
        char[] alphubetEngTop = Strings.eng.toUpperCase().toCharArray();
        char[] strings = str1.toCharArray();
        String[] countWords = str1.split(" ");

        //TODO Code style. Needs reformat or extraction to methods / variables / constants
        int dot;
        //while (true) {
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < alphubet.length; j++) {

                if ((int) strings[i] == (int) alphubet[j]) {
                    dot = j - count;
                    if (dot < 0) {
                        j = alphubet.length + dot;
                        dot = j;
                    }
                    strings[i] = alphubet[dot];


                } else if ((int) strings[i] == (int) alphubetTop[j]) {
                    dot = j - count;
                    if (dot < 0) {
                        j = alphubetTop.length + dot;
                        dot = j;
                    }
                    strings[i] = alphubetTop[dot];


                }

            }

        }
        //TODO Code style. Needs reformat or extraction to methods / variables / constants
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < alphubetEng.length; j++) {

                if ((int) strings[i] == (int) alphubetEng[j]) {
                    dot = j - count;
                    if (dot < 0) {
                        j = alphubetEng.length + dot;
                        dot = j;
                    }
                    strings[i] = alphubetEng[dot];


                } else if ((int) strings[i] == (int) alphubetEngTop[j]) {
                    dot = j - count;
                    if (dot < 0) {
                        j = alphubetEngTop.length + dot;
                        dot = j;
                    }
                    strings[i] = alphubetEngTop[dot];


                }
            }
            stringBuilder.append(strings[i]);
        }

        try {
            Files.writeString(path2, stringBuilder);
            return new Result(ResultCode.OK, "Перевел");
        } catch (IOException e) {
            return new Result(ResultCode.ERROR, "Ошибка");
        }


    }
}
