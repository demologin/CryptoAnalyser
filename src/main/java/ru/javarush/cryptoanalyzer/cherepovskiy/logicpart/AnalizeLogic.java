package ru.javarush.cryptoanalyzer.cherepovskiy.logicpart;

import ru.javarush.cryptoanalyzer.cherepovskiy.exceptions.AppException;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class AnalizeLogic {
    public static Map<Character, Integer> mapEncrypted = new HashMap<>();
    public static Map<Character, Integer> mapDictionary = new HashMap<>();

    public static void startAnalyze(Path pathEncrypted, Path pathDictionary, Path pathAnalysed) {

        try (Reader readerEncrypted = new FileReader(String.valueOf(pathEncrypted));
             Reader readerDictionary = new FileReader(String.valueOf(pathDictionary))) {
//  заносим значения из зашифрованного списка и dictionary в 2 мапы
            while (readerEncrypted.ready()) {
                char key = (char) readerEncrypted.read();
                if (mapEncrypted.containsKey(key)) {
                    mapEncrypted.put(key, mapEncrypted.get(key) + 1);
                } else mapEncrypted.put(key, 1);
            }
            while (readerDictionary.ready()) {
                char key =  (char) readerDictionary.read();
                if (mapDictionary.containsKey(key)) {
                    mapDictionary.put(key, mapDictionary.get(key) + 1);
                } else mapDictionary.put(key, 1);
            }
        } catch (IOException e) {
            throw new AppException(e.getMessage());
        }
//  сортируем значения по частоте
        MyComparator comparator;
        comparator = new MyComparator(mapEncrypted);
        Map<Character, Integer> newMapEncrypt = new TreeMap<>(comparator);
        newMapEncrypt.putAll(mapEncrypted);

        comparator = new MyComparator(mapDictionary);
        Map<Character, Integer> newMapDictionary = new TreeMap<>(comparator);
        newMapDictionary.putAll(mapDictionary);

//  перебрасываем отсортированые ключи в списки
        Set<Character> keySetE = newMapEncrypt.keySet();
        ArrayList<Character> listOfKeysE = new ArrayList<>(keySetE);

        Set<Character> keySetD = newMapDictionary.keySet();
        ArrayList<Character> listOfKeysD = new ArrayList<>(keySetD);

//  заменяем отсортированые по частоте символы из зашифрованного файла на символы из dictionary
        try (Reader reader = new FileReader(String.valueOf(pathEncrypted));
             Writer writer = new FileWriter(String.valueOf(pathAnalysed))) {
            while (reader.ready()) {
                char old = (char) reader.read();
                int index = listOfKeysE.indexOf(old);
                if (index != -1) {
                    char nova = listOfKeysD.get(index);
                    writer.write(nova);
                }
            }
            System.out.println("Analyzed finished!");
        } catch (IOException e) {
            throw new AppException(e.getMessage());
        }

    }
}
