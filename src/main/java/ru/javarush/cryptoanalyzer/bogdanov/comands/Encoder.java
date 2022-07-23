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


public class Encoder implements Action{
    @Override
    public Result execute(String[] parameters) {
        Path path = Paths.get(parameters[0]);
        Path path2 = Paths.get(parameters[1]);
        StringBuilder stringBuilder = new StringBuilder();
        byte[] bytes;
        try {
            bytes = Files.readAllBytes(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String str1 = new String(bytes, StandardCharsets.UTF_8);

        int count= Integer.parseInt(parameters[2]);
        int countPrest =100;
        char[] alphubet = Strings.rus.toCharArray();
        char[] alphubetTop = Strings.rus.toUpperCase().toCharArray();
        char[] alphubetEng = Strings.eng.toCharArray();
        char[] alphubetEngTop = Strings.eng.toUpperCase().toCharArray();
        char[] strings = str1.toCharArray();
        String[] countWords = str1.split(" ");

        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < alphubet.length; j++) {
                if ((int) strings[i] == (int) alphubet[j]) {
                    int dot = j + count;
                    if (dot < alphubet.length) {
                        strings[i] = alphubet[dot];
                        break;
                    } else {
                        int t = dot - alphubet.length;
                        strings[i] = alphubet[t];
                        break;
                    }


                }
                if ((int) strings[i] == (int) alphubetTop[j]) {
                    int dot = j + count;
                    if (dot < alphubetTop.length) {
                        strings[i] = alphubetTop[dot];
                        break;
                    } else if (dot >= alphubet.length) {
                        int t = dot - alphubet.length;
                        strings[i] = alphubetTop[t];
                        break;
                    }

                }


            }

        }
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < alphubetEng.length; j++) {
                if ((int) strings[i] == (int) alphubetEng[j]) {
                    int dot = j + count;
                    if (dot < alphubetEng.length) {
                        strings[i] = alphubetEng[dot];
                        break;
                    } else{
                        int t = dot - alphubetEng.length;
                        strings[i] = alphubetEng[t];
                        break;
                    }

                }
                if ((int) strings[i] == (int) alphubetEngTop[j]) {
                    int dot = j + count;
                    if (dot < alphubetEng.length) {
                        strings[i] = alphubetEngTop[dot];
                        break;
                    } else{
                        int t = dot - alphubetEng.length;
                        strings[i] = alphubetEngTop[t];
                        break;
                    }

                }
            }
            stringBuilder.append(strings[i]);
        }

        try {
            Files.writeString(path2,stringBuilder);
            return new Result(ResultCode.OK,"Перевел.");
        } catch (IOException e) {
            return  new Result(ResultCode.ERROR,"Ошибка");
        }

    }

}
