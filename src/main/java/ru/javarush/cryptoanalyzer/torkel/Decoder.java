package ru.javarush.cryptoanalyzer.torkel;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Decoder {

    public int brutForce() throws URISyntaxException {
        //TODO Code style. Long code. Needs to be split into several methods
        String fileNamePrefix = "keyHacking";
        //TODO Coding. Magic values or methods. Bad reading and understanding
        String fileNameSuffix = ".txt";


        Path inputFilePath = Path.of(PathFinder.getRoot()+"encrypted_file.txt");

        Map<Long, Integer> key2WordsOccurencies = new HashMap<>();
        long maxOftenWords = 0;
        for (int i = 0; i < Main.ALPHABET.length; i++) {

            Map<Character, Character> alphChar2EncryptedChar = new HashMap<>();
            File destFile = new File(PathFinder.getRoot(), fileNamePrefix + i + fileNameSuffix);

            PrintWriter printWriter = null;
            try (BufferedReader br = Files.newBufferedReader(inputFilePath)) {

                FileWriter fileWriter = new FileWriter(destFile.getPath());
                printWriter = new PrintWriter(fileWriter);

                String line;
                long oftenWordsMetTimes = 0;
                while ((line = br.readLine()) != null) {
                    String convertedLine = getConvertedLine(line.toLowerCase(), -i, alphChar2EncryptedChar);
                    for (Pattern p: Main.often100Words) {
                        oftenWordsMetTimes = oftenWordsMetTimes + metTimes(convertedLine, p);
                    }
                    printWriter.println(convertedLine);
                }
                maxOftenWords = Math.max(maxOftenWords, oftenWordsMetTimes);
                key2WordsOccurencies.put(oftenWordsMetTimes, i);
            } catch (IOException e) {
                //TODO Coding. We see console (System.out.print) here. Need move the output to View layer
                System.out.println("Проблема с чтением файла");
            } finally {
                assert printWriter != null;
                printWriter.close();
            }
        }

        return key2WordsOccurencies.get(maxOftenWords);
    }

    public void encrypt(String in, String out, int key) throws URISyntaxException {

        Path inputFilePath = Paths.get(Objects.requireNonNull(Main.class.getClassLoader().getResource(in)).toURI());
        Path resources = inputFilePath.getParent();
        File destFile = new File(resources.toFile(), out);

        File destFile2 = new File(PathFinder.getRoot(), out);

        writeToFile(key, inputFilePath, destFile);
        writeToFile(key, inputFilePath, destFile2);
    }

    private void writeToFile(int key, Path inputFilePath, File destFile) {
        Map<Character, Character> alphChar2EncryptedChar = new HashMap<>();

        PrintWriter printWriter = null;
        try (BufferedReader br = Files.newBufferedReader(inputFilePath)) {

            FileWriter fileWriter = new FileWriter(destFile.getPath());
            printWriter = new PrintWriter(fileWriter);

            String line;
            while ((line = br.readLine()) != null) {
                printWriter.println(getConvertedLine(line.toLowerCase(), key, alphChar2EncryptedChar));
            }
        } catch (IOException e) {
            System.out.println("Проблема с чтением файла");
        } finally {
            assert printWriter != null;
            printWriter.close();
        }
    }

    private String getConvertedLine(String inputLine,
                                    int key,
                                    Map<Character, Character> alphChar2EncryptedChar) {
        StringBuilder convertedLineSB = new StringBuilder();
        for (int i = 0; i < inputLine.length(); i++) {
            convertedLineSB.append(alphChar2EncryptedChar.computeIfAbsent(inputLine.charAt(i), (alphChar) -> {
                int indexOfAlphChar = getIndexOfElementInArray(alphChar);
                int newIndex = (indexOfAlphChar + key) % Main.ALPHABET.length;
                if (newIndex < 0) {
                    newIndex = Main.ALPHABET.length + newIndex;
                }
                return  Main.ALPHABET[newIndex];
            }));
        }
        return convertedLineSB.toString();
    }

    private int metTimes(String str, Pattern p) {
        int res = 0;
        Matcher m = p.matcher(str);
        while(m.find()) {
            res++;
        }
        return res;
    }
    //TODO Coding. Need use OOP here. Many static methods is not best practice.
    private static int getIndexOfElementInArray(char ch) {
        for (int i = 0; i < Main.ALPHABET.length; i++) {
            if (Main.ALPHABET[i] == ch) {
                return i;
            }
        }
        return -1;
    }
}
