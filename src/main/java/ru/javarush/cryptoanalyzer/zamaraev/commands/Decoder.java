package ru.javarush.cryptoanalyzer.zamaraev.commands;

import ru.javarush.cryptoanalyzer.zamaraev.constans.Strings;
import ru.javarush.cryptoanalyzer.zamaraev.entity.Result;
import ru.javarush.cryptoanalyzer.zamaraev.entity.ResultCode;
import ru.javarush.cryptoanalyzer.zamaraev.util.PathFinder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;


public class Decoder implements Action{
    @Override
    public Result execute(String[] parameters) {
        //TODO Code style. Long code. Needs to be split into several methods
        String encrypted = parameters[0];
        String decryptedFile = parameters[1];
        Path pathIn = Path.of(PathFinder.getRoot() + encrypted);
        Path pathOut = Path.of(PathFinder.getRoot() + decryptedFile);
        try {
            if(!Files.exists(pathOut)){
                Files.createFile(pathOut);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int key = Integer.parseInt(parameters[2]);

        try(FileReader reader = new FileReader(String.valueOf(pathIn));
            FileWriter writer = new FileWriter(String.valueOf(pathOut))){

            StringBuilder text = new StringBuilder();
            while (reader.ready()){
                text.append((char) reader.read());
            }

            String someText = decoderText(text.toString(),key);
            char[] decryptedTextArray = someText.toCharArray();
            for (char c : decryptedTextArray) {
                writer.append(c);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new Result(ResultCode.OK,"The file " + pathIn.getFileName() +
                " was decrypted using decoder " +
                ", the decrypted text is in the file " + pathOut.getFileName());
    }
    //TODO Coding. Need use OOP here. Many static methods is not best practice.
    private static String decoderText(String text2,int key) {
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList(text2.split("")));
        StringBuilder stringBuilder1 = new StringBuilder();
        for(String str : list1){
            stringBuilder1.append(characterDecoder(str,key));
        }

        return stringBuilder1.toString();
    }

    //TODO Coding. Need use OOP here. Many static methods is not best practice.
    private static String characterDecoder(String s, int key) {
        for (int i = 0; i < Strings.alphabet.length; i++) {
            if(Strings.alphabet[i].equals(s.toLowerCase())){
                if(i - key >= 0){
                    return Strings.alphabet[i - key];
                }else {
                    return Strings.alphabet[i - key + Strings.alphabet.length];
                }
            }
        }
        //TODO ---  ???? null ????
        return null;
    }
}
