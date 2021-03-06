package ru.javarush.cryptoanalyzer.zamaraev.commands;

import ru.javarush.cryptoanalyzer.zamaraev.constans.Strings;
import ru.javarush.cryptoanalyzer.zamaraev.entity.Result;
import ru.javarush.cryptoanalyzer.zamaraev.entity.ResultCode;
import ru.javarush.cryptoanalyzer.zamaraev.util.PathFinder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class BruteForce implements Action {

    @Override
    public Result execute(String[] parameters) {
        String encrypted = parameters[0];
        String brutForcedFile = parameters[1];
        Path pathIn = Path.of(PathFinder.getRoot() + encrypted);
        Path pathOut = Path.of(PathFinder.getRoot() + brutForcedFile);
        
        try {
            if(!Files.exists(pathOut)){
                Files.createFile(pathOut);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (FileReader reader = new FileReader(String.valueOf(pathIn))){
            StringBuilder text = new StringBuilder();
            while (reader.ready()){
                text.append((char) reader.read());
            }

            if(text.toString().length() <= 1500){
                return bruteForceForSmallText(text,pathIn,pathOut);
            }else{
               return bruteForceForBigText(text,pathIn,pathOut);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private Result bruteForceForSmallText(StringBuilder text, Path pathIn, Path pathOut) {
        //TODO Code style. Long code. Needs to be split into several methods
        try(FileWriter writer = new FileWriter(String.valueOf(pathOut))){

            int count = 0;
            int stringCount = 0;
            String textBruteForce;
            String finish = "";

            for (int x = 1; true ; x++) {
                for (int key = 1; key <= Strings.alphabet.length; key++) {
                    textBruteForce = decoderText(text.toString(),key);
                    String[] textArr = textBruteForce.split("");

                    for (int i = 0; i < textArr.length; i++) {
                        switch (textArr[i]) {
                            case ",":
                            case ".":
                            case "?":
                            case "!":
                                if (i < textArr.length - 1 && textArr[i + 1].equals(" ")) {
                                    count++;
                                }
                                break;
                            case " ":
                                count++;
                                break;
                        }
                    }

                    if(count >= x){
                        stringCount++;
                        finish = textBruteForce;

                    }
                    count = 0;
                }
                if(stringCount == 1){
                    char[] bruteForcedTextArray = finish.toCharArray();
                    for (char c : bruteForcedTextArray) {
                        writer.append(c);
                    }
                    break;
                }
                stringCount = 0;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new Result(ResultCode.OK,"The file " + pathIn.getFileName() +
                " was decrypted using bruteforce " +
                "the decrypted text is in the file " + pathOut.getFileName());
    }

    private Result bruteForceForBigText(StringBuilder text,Path pathIn ,Path pathOut) {
        int keyFinal = 0;
        try(FileWriter writer = new FileWriter(String.valueOf(pathOut))){
            
            int count = 0;

            int[] keys = new int[Strings.alphabet.length + 1];
            for(int key = 1 ; key <= Strings.alphabet.length; key++){
                String textBruteForce = decoderText(text.toString(),key);
                String[] textArray = textBruteForce.split("");
                String[] textArr = new String[textArray.length/2 + 1];
                int countArr = 0;
                for(int x = 0;x < textArray.length ; x++){
                    if(x % 2 == 0){
                        if(x == textArray.length - 1){
                            textArr[countArr] = textArray[x];
                        }else{
                            textArr[countArr] = textArray[x] + textArray[x + 1];
                        }
                        countArr++;

                    }
                }
                if(textArr[textArr.length - 1] == null){
                    textArr[textArr.length - 1] = "";
                }

                for (String s : textArr) {
                    switch (s) {
                        case ", ", ". ", "? ", "; ", "! ", ": " -> count++;
                    }
                }
                keys[key] = count;
                count = 0;
            }

            int max = Integer.MIN_VALUE;
            for(int x = 0; x < keys.length;x++){
                if(max < keys[x]){
                    max = keys[x];
                    keyFinal = x;
                }
            }
            char[] bruteForcedTextArray = decoderText(text.toString(),keyFinal).toCharArray();
            for (char c : bruteForcedTextArray) {
                writer.append(c);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //TODO Code style. Needs reformat or extraction to methods / variables / constants
        return new Result(ResultCode.OK,"The file " + pathIn.getFileName() +
                " was decrypted using bruteforce, key - " + keyFinal +
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
        return "";
    }
}
