package ru.javarush.cryptoanalyzer.likhter.commands;
import ru.javarush.cryptoanalyzer.likhter.constants.Alphabet;
import ru.javarush.cryptoanalyzer.likhter.entity.Result;
import ru.javarush.cryptoanalyzer.likhter.entity.ResultCode;
import ru.javarush.cryptoanalyzer.likhter.exeption.ApplicationExeption;
import ru.javarush.cryptoanalyzer.likhter.util.PathFinder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Decoder implements Action {
    @Override
    public Result execute(String[] parameters) {
        Path input = PathFinder.getRoot(parameters[0]);
        Path output = PathFinder.getRoot(parameters[1]);
        int key = Integer.parseInt(parameters[2]);
        try (BufferedReader reader = Files.newBufferedReader(input);
             BufferedWriter writer = Files.newBufferedWriter(output)
        ) {
            int value;
            int length = Alphabet.ALPHABET_ARRAY.length;
            while ((value = reader.read()) > -1) {
                char character = (char) value;
                character = Character.toLowerCase(character);
                //TODO Code style. Many warnings. Skip or fix it.
                if (Alphabet.ALPHABET_MAP.containsKey(character)) {
                    Integer index = Alphabet.ALPHABET_MAP.get(character);
                    index = (index - key) % length;
                    writer.write(Alphabet.ALPHABET_ARRAY[index]);
                } else if (character == '\n') {
                    writer.write(character);
                    //TODO Code style. Many warnings. Skip or fix it.
                } else if (!Alphabet.ALPHABET_MAP.containsKey(character)) {
                    writer.write(character);
                }
            }
        } catch (IOException e) {
            throw new ApplicationExeption("File not found ", e);
        }
        return new Result(ResultCode.OK, "decode all bytes from " + parameters[0].toString() + " and write to " + parameters[1].toString());
    }
}