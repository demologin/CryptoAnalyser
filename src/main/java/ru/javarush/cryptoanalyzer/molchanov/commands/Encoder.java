package ru.javarush.cryptoanalyzer.molchanov.commands;

import ru.javarush.cryptoanalyzer.molchanov.constants.Strings;
import ru.javarush.cryptoanalyzer.molchanov.entity.Result;
import ru.javarush.cryptoanalyzer.molchanov.entity.ResultCode;
import ru.javarush.cryptoanalyzer.molchanov.util.PathFinder;
import ru.javarush.cryptoanalyzer.molchanov.util.TextUtilMethods;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Encoder implements Action{
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
            //TODO Coding. We see console (System.out.print) here. Need move the output to View layer
            System.out.println("Invalid cryptoKey format");
        }

        try {
            lines = Files.readAllLines(pathIn, StandardCharsets.UTF_8);
        } catch (IOException e) {
            return new Result(ResultCode.ERROR, "Writing to file failed" + pathOut);
        }

        char[] textInChar = TextUtilMethods.textInCharArray(lines);
        encripting(textInChar, cryptoKey);

        try {
            Files.writeString(pathOut, String.copyValueOf(textInChar));
        } catch (IOException e) {
            //TODO Coding. We see console (System.out.print) here. Need move the output to View layer
            System.out.println("Writing to file failed");
        }

        return new Result(ResultCode.OK, "Text was encripted" + pathOut);
    }
    private static void encripting (char[] allSymbols, int criptoKey){
        int ck = criptoKey%Strings.ALPHABET.size();
        System.out.println(ck);
        for (int i = 0; i < allSymbols.length; i++) {
            if(Strings.ALPHABET.contains(Character.toLowerCase(allSymbols[i]))){
                int index = Strings.ALPHABET.indexOf(Character.toLowerCase(allSymbols[i]));
                allSymbols[i] = Strings.ALPHABET.get((index + ck)%Strings.ALPHABET.size());
            }
        }
    }
}
