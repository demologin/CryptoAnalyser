package ru.javarush.cryptoanalyzer.afonin.util;

import ru.javarush.cryptoanalyzer.afonin.constans.BaseAlphabet;

import java.util.*;
import java.util.stream.Collectors;


import static java.util.stream.Collectors.joining;


public class ScramblerUtil {

    //TODO Coding. Need use private constructor in static context.

    public static void cesarCipher(String inputTxtFile, String outputTxtFile, int keyShift){
        List<String> inputText = MyFileUtils.readText(inputTxtFile);
        Map<Character, Character> cryptoAlphabet = getShiftCryptoAlphabet(keyShift);
        List<String> shiftedText = replaceSymbols(inputText, cryptoAlphabet);
        MyFileUtils.saveToFile(outputTxtFile, shiftedText);
    }

    public static void staticticalDecrypt(String inputTxtFile, String outputTxtFile, String dictionaryFileTxt) {
        List<String> inputText = MyFileUtils.readText(inputTxtFile);
        List<String> dict = MyFileUtils.readText(dictionaryFileTxt);
        Map<Character, Character> decodeAlphabet = getStatisticalDecodeAlphabet(dict, inputText);
        List<String> decryptedText = ScramblerUtil.replaceSymbols(inputText, decodeAlphabet);
        MyFileUtils.saveToFile(outputTxtFile, decryptedText);
    }

    public static void bruteForceDecode(String inputTxtFile, String outputTxtFile){
        List<String> inputText = MyFileUtils.readText(inputTxtFile);
        List<String> decryptedText = new ArrayList<>();
        for (int keyShift = 0; keyShift < BaseAlphabet.ALPHABET.length; keyShift++) {
            Map<Character, Character> cryptoAlphabet = getShiftCryptoAlphabet(keyShift);
            decryptedText = replaceSymbols(inputText, cryptoAlphabet);
            if (Analyser.isText(decryptedText)){
                break;
            }
        }
        MyFileUtils.saveToFile(outputTxtFile, decryptedText);
    }

    private static Map<Character, Character> getShiftCryptoAlphabet(int keyShift) {
        Map<Character, Character> cryptoAlphabet = new HashMap<>();
        char[] alphabet = BaseAlphabet.ALPHABET;
        keyShift = alphabet.length + (keyShift % alphabet.length);
        for (int i = 0; i < alphabet.length; i++) {
            cryptoAlphabet.put(alphabet[i], alphabet[(i + keyShift) % alphabet.length]);
        }
        return cryptoAlphabet;
    }

    private static Map<Character, Character> getStatisticalDecodeAlphabet(List<String> dict, List<String> text){

        Map<Character, Double> frequencySymbolsInText = Analyser.getFrequencySymbols(text);
        Map<Character, Double> frequencySymbolsInDict = Analyser.getFrequencySymbols(dict);
        return frequencySymbolsInText.entrySet().stream()
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                v -> getCharByFrequency(v.getValue(), frequencySymbolsInDict)));
    }

    private static List<String> replaceSymbols(List<String> text, Map<Character, Character> alphabet){
        return text.stream()
                .map(t ->  t
                        .toLowerCase()
                        .chars()
                        .mapToObj(i -> (char) i)
                        .filter(alphabet::containsKey)
                        .map(alphabet::get)
                        .map(Object::toString)
                        .collect(joining()))
                .toList();
    }

    private static void correctAlphabet(Map<Character, Character> alphabet, char c1, char c2){
        Character keySymbolFirst = getKeyByValue(alphabet, c1);
        Character keySymbolSecond = getKeyByValue(alphabet, c2);
        alphabet.replace(keySymbolFirst, c2);
        alphabet.replace(keySymbolSecond, c1);
    }

    private static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        return map.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), value))
                .map(Map.Entry::getKey)
                .findAny()
                .orElse(null);
    }

    private static Character getCharByFrequency(double frequency, Map<Character, Double> srcFrequencySymbols) {
        Character symbol = srcFrequencySymbols.entrySet().stream()
                .min(Comparator.comparingDouble(e -> Math.abs(e.getValue() - frequency)))
                .map(Map.Entry::getKey)
                .orElse('!');
        srcFrequencySymbols.remove(symbol);
        return symbol;
    }

}
