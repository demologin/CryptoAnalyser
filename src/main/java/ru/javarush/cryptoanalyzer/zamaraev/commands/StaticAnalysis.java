package ru.javarush.cryptoanalyzer.zamaraev.commands;


import ru.javarush.cryptoanalyzer.zamaraev.entity.Result;
import ru.javarush.cryptoanalyzer.zamaraev.entity.ResultCode;
import ru.javarush.cryptoanalyzer.zamaraev.util.PathFinder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StaticAnalysis implements Action {
    @Override
    public Result execute(String[] parameters) {
        //TODO Code style. Long code. Needs to be split into several methods
        String encrypted = parameters[0];
        String dict = parameters[1];
        String staticanalysis = parameters[2];
        Path pathIn = Path.of(PathFinder.getRoot() + encrypted);
        Path dictPath = Path.of(PathFinder.getRoot() + dict);
        Path pathOut = Path.of(PathFinder.getRoot() + staticanalysis);
        try {
            if(!Files.exists(pathOut)){
                Files.createFile(pathOut);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(FileReader readerEncrypt = new FileReader(String.valueOf(pathIn));
            FileReader readerDict = new FileReader(String.valueOf(dictPath));
            FileWriter writer = new FileWriter(String.valueOf(pathOut))) {

            StringBuilder encryptText = new StringBuilder();
            while (readerEncrypt.ready()){
                encryptText.append(String.valueOf((char) readerEncrypt.read()).toLowerCase());
            }

            char[] arrayOfEncryptedTextCharacters = encryptText.toString().toCharArray();

            Map<Character,Integer> mapCharactersCountEncrypt = new HashMap<>();

            for(char c : arrayOfEncryptedTextCharacters){
                if(mapCharactersCountEncrypt.containsKey(c)){
                    mapCharactersCountEncrypt.put(c,mapCharactersCountEncrypt.get(c) + 1);
                }else{
                    mapCharactersCountEncrypt.put(c,1);
                }
            }
            //----------------------------------------------------------------------------------------------------
            StringBuilder dictText = new StringBuilder();
            while (readerDict.ready()){
                dictText.append(String.valueOf((char) readerDict.read()).toLowerCase());
            }

            char[] arrayOfDictTextCharacters = dictText.toString().toCharArray();

            Map<Character,Integer> mapCharactersCountDict = new HashMap<>();

            for(char c : arrayOfDictTextCharacters){
                if(mapCharactersCountDict.containsKey(c)){
                    mapCharactersCountDict.put(c,mapCharactersCountDict.get(c) + 1);
                }else{
                    mapCharactersCountDict.put(c,1);
                }
            }
            //----------------------------------------------------------------------------------------------------
            TreeMap<Double,Character> treeMapDictCharacters = new TreeMap<>();
            for (Map.Entry<Character,Integer> pairMapDict : mapCharactersCountDict.entrySet()){
                double key = pairMapDict.getValue() * 1.0 / arrayOfDictTextCharacters.length * 100;

                if(treeMapDictCharacters.containsKey(key)){
                    treeMapDictCharacters.put(key + Math.random() / 10 ,pairMapDict.getKey());
                }else{
                    treeMapDictCharacters.put(key,pairMapDict.getKey());
                }
            }
            //----------------------------------------------------------------------------------------------------

            TreeMap<Double,Character> treeMapEncryptCharacters = new TreeMap<>();
            for (Map.Entry<Character,Integer> pairMapEncrypt : mapCharactersCountEncrypt.entrySet()){
                double key = pairMapEncrypt.getValue() * 1.0 / arrayOfEncryptedTextCharacters.length * 100;

                if(treeMapEncryptCharacters.containsKey(key)){
                    treeMapEncryptCharacters.put(key + Math.random() / 10 ,pairMapEncrypt.getKey());
                }else{
                    treeMapEncryptCharacters.put(key,pairMapEncrypt.getKey());
                }
            }

            HashMap<Character,Character> finalMap = new HashMap<>();
            for(var c : treeMapEncryptCharacters.entrySet()){
                if(treeMapDictCharacters.ceilingKey(c.getKey()) == null){
                    finalMap.put(c.getValue(),treeMapDictCharacters.get(treeMapDictCharacters.floorKey(c.getKey())));
                }else {
                    finalMap.put(c.getValue(),treeMapDictCharacters.get(treeMapDictCharacters.ceilingKey(c.getKey())));
                }


            }

            for(var letter : arrayOfEncryptedTextCharacters){
                writer.append(finalMap.get(letter));

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new Result(ResultCode.OK,"The file " + pathIn.getFileName() +
                " was decrypted using Static Analysis " +
                "the decrypted text is in the file " + pathOut.getFileName());
    }
}
