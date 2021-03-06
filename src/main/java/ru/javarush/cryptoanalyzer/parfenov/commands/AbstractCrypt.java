package ru.javarush.cryptoanalyzer.parfenov.commands;

import ru.javarush.cryptoanalyzer.parfenov.entity.Result;
import ru.javarush.cryptoanalyzer.parfenov.entity.ResultCode;
import ru.javarush.cryptoanalyzer.parfenov.exception.ApplicationException;

import java.io.*;
import java.nio.file.Path;

public abstract class AbstractCrypt {
    //TODO Code style. User russain comments? Bad English is much better than the best Russian comments.
    //здесь еще можно было попробовать объединить поведение brute и statistics, но не успел
    public Result getResult(Path in, Path out, int key, String alphabet, boolean toLower) {
        try (BufferedReader reader = new BufferedReader(new FileReader(in.toFile()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(out.toFile()))) {
            int character;
            while ((character = reader.read()) != -1) {
                if(toLower) {
                    character = Character.toLowerCase(character);
                }
                if ((character = encrypting(character, key, alphabet)) != -1) {
                    writer.write(character);
                }
            }
        } catch (IOException e) {
            throw new ApplicationException("It's a problem with your file", e);
        }
        return new Result(ResultCode.OK, "Done");
    }
    public int encrypting(int character, int key, String alphabet) {
        int a = alphabet.indexOf((char)character);
        if(a == -1) return a;
        int b = Math.floorMod((a + (key % alphabet.length())), alphabet.length());
        return alphabet.charAt(b);
    }
}
