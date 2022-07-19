package ru.javarush.cryptoanalyzer.akhundov;

import java.io.*;
import java.util.*;

import static ru.javarush.cryptoanalyzer.akhundov.Alphabet.ALPHABET;

public class Decryptor {

    private  String fileIn;
    private  String fileOut;
    private final Scanner sc = new Scanner(System.in);

    public  void init(){
        System.out.println("Введите корректный путь файла для чтения: ");
        fileIn = sc.nextLine();

        System.out.println("Введите корректный путь файла для записи: ");
        fileOut = sc.nextLine();
    }

    public void decryptByKey(int key){

        try(FileReader reader = new FileReader(fileIn);
            FileWriter writer = new FileWriter(fileOut, false))
        {
            int c;
            while((c=reader.read())!=-1) {
                if (ALPHABET.contains(Character.toLowerCase((char) c))) {
                    int index = ALPHABET.indexOf(Character.toLowerCase((char) c));
                    int newIndex = index - key;
                    if (newIndex < 0) {
                        newIndex = newIndex + ALPHABET.size();
                    }
                    writer.append(ALPHABET.get(newIndex));
                }
            }
        } catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        System.out.println("Операция прошла успешно!");
    }

    public void decryptByBrute(){
        int bestKey = -9999;
        int bestSpaceCount = -9999;
        int spaceCount;


        for(int key = 1; key <= ALPHABET.size(); key++)
        {
            spaceCount = 0;
            try(FileReader reader = new FileReader(fileIn)) {
                int c;
                while ((c = reader.read()) != -1) {
                    if(ALPHABET.contains(Character.toLowerCase((char)c))) {
                        int index = ALPHABET.indexOf(Character.toLowerCase((char) c));
                        int newIndex = index - key;
                        if (newIndex < 0) {
                            newIndex = newIndex + ALPHABET.size();
                        }
                        if (ALPHABET.get(newIndex).equals(' ')) {
                            spaceCount++;
                        }
                    }
                }
                if(spaceCount > bestSpaceCount){
                    bestSpaceCount = spaceCount;
                    bestKey = key;
                }
            }
            catch(IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        decryptByKey(bestKey);
    }

    public void decryptByAnalyze(){
        HashMap<Character, Double> styleMap;
        ArrayList<Character> mostOftenFoundForStyleText;
        ArrayList<Character> mostOftenFoundForEncryptedText;
        String styleFile;

        System.out.println("Введите корректный путь файла для проверки стиля : ");
        styleFile = sc.nextLine();

        styleMap = constructStyleMap(styleFile);
        mostOftenFoundForStyleText = sortCharactersByPercentage(styleMap);

        styleMap = constructStyleMap(fileIn);
        mostOftenFoundForEncryptedText = sortCharactersByPercentage(styleMap);

        try(FileReader reader = new FileReader(fileIn);
            FileWriter writer = new FileWriter(fileOut, false))
        {
            int c;
            while((c=reader.read())!=-1) {
                    writer.append(mostOftenFoundForStyleText.get(mostOftenFoundForEncryptedText.indexOf((char)c)));
            }
        } catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        System.out.println("Операция прошла успешно!");

    }

    private ArrayList<Character> sortCharactersByPercentage(HashMap<Character, Double> map){
        ArrayList<Character> sortedMap = new ArrayList<>();
        boolean goNext = true;

        while(goNext){
            char c = findMaxValue(map);
            sortedMap.add(c);
            map.remove(c);
            if(map.isEmpty())
            {
                goNext = false;
            }
        }

        return sortedMap;
    }

    private char findMaxValue(HashMap<Character, Double> map){
        char toDelete = ' ';
        double max = 0;

        for(Map.Entry<Character, Double> entry : map.entrySet())
        {
            if(entry.getValue() > max) {
                max = entry.getValue();
                toDelete = entry.getKey();
            }
        }
        return toDelete;
    }

    private HashMap<Character, Double> constructStyleMap(String styleFile) {
        HashMap<Character, Double> styleMap = new HashMap<>();
        HashSet<Character> alphabet = getAlphabet(fileIn);
        boolean isChangedCase = true;

        for(Character c : alphabet){
            if(Character.isAlphabetic(c) && Character.isUpperCase(c)){
                isChangedCase = false;
            }
        }

        try (FileReader reader = new FileReader(styleFile)) {
            int c;
            while ((c = reader.read()) != -1) {
                if(isChangedCase) {
                    if(alphabet.contains(Character.toLowerCase((char)c))) {
                        if (!styleMap.containsKey(Character.toLowerCase((char)c))) {
                            styleMap.put(Character.toLowerCase((char)c), 1.0);
                        } else {
                            styleMap.put(Character.toLowerCase((char)c), styleMap.get(Character.toLowerCase((char)c)) + 1);
                        }
                    }
                }
                else{
                    if(alphabet.contains((char)c)) {
                        if (!styleMap.containsKey((char) c)) {
                            styleMap.put((char)c, 1.0);
                        } else {
                            styleMap.put((char)c, styleMap.get((char)c) + 1);
                        }
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return styleMap;
    }

    private HashSet<Character> getAlphabet(String fileName)
    {
        HashSet<Character> alphabet= new HashSet<>();

        try (FileReader reader = new FileReader(fileName)) {
            int c;
            while ((c = reader.read()) != -1) {
                alphabet.add((char)c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        alphabet.add(' ');
        alphabet.add('\n');

        return alphabet;
    }
}
