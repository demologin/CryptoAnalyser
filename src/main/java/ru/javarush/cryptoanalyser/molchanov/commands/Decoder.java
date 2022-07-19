package ru.javarush.cryptoanalyser.molchanov.commands;

import ru.javarush.cryptoanalyser.molchanov.Exception.ApplicationException;
import ru.javarush.cryptoanalyser.molchanov.constants.Strings;
import ru.javarush.cryptoanalyser.molchanov.entity.Result;
import ru.javarush.cryptoanalyser.molchanov.entity.ResultCode;
import ru.javarush.cryptoanalyser.molchanov.util.PathFinder;
import ru.javarush.cryptoanalyser.molchanov.util.TextUtilMethods;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Decoder implements Action{
    @Override
    public Result execute(String[] parameters) {
        String txtFile = parameters[0];
        String encryptedFile = parameters[1];
        Path pathIn = Path.of(PathFinder.getRoot() + txtFile);
        Path pathOut = Path.of(PathFinder.getRoot() + encryptedFile);
        List<String> lines;
        int cryptoKey = 0;
        try {
            cryptoKey = Integer.parseInt(parameters[2]);
            System.out.println(cryptoKey);
        } catch (NumberFormatException e){
            System.out.println("Invalid cryptoKey format");
        }

        try {
            lines = Files.readAllLines(pathIn, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new ApplicationException("FileNotFound");
        }
        char[] textInChar = TextUtilMethods.textInCharArray(lines);
        decoding(textInChar, cryptoKey);

        try {
            Files.writeString(pathOut, String.copyValueOf(textInChar));
        } catch (IOException e) {
            return new Result(ResultCode.ERROR, "Writing to file failed" + pathOut);
        }

        return new Result(ResultCode.OK, "Text was decripted" + pathOut);
    }
    public static void decoding (char[] allSymbols, int criptoKey){
        int ck = criptoKey%Strings.ALPHABET.size();
        for (int i = 0; i < allSymbols.length; i++) {
            if(Strings.ALPHABET.contains(Character.toLowerCase(allSymbols[i]))){
                int index = Strings.ALPHABET.indexOf(Character.toLowerCase(allSymbols[i]));
                if(index > criptoKey) allSymbols[i] = Strings.ALPHABET.get((index - ck) % Strings.ALPHABET.size());
                else allSymbols[i] = Strings.ALPHABET.get((Strings.ALPHABET.size() - ck + index)% Strings.ALPHABET.size());
            }
        }
    }
}
