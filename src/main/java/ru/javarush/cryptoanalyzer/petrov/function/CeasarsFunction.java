package ru.javarush.cryptoanalyzer.petrov.function;

import java.util.Arrays;

public class CeasarsFunction {
    public static StringBuilder shift(int[] offsetCharacters, int range, String inputStr) {
        Arrays.sort(offsetCharacters);
        StringBuilder stringBuilder = new StringBuilder(inputStr);
        if(offsetCharacters.length == range){
            return stringBuilder;
        }
        if (Math.abs(range) > offsetCharacters.length) {
            range = range % offsetCharacters.length;
        }
        int indexInOffset;
        int currentChar;
        int newChar;
        for(int i = 0; i < stringBuilder.length(); ++i) {
            currentChar = stringBuilder.charAt(i);
            indexInOffset = Arrays.binarySearch(offsetCharacters, currentChar);
            if(indexInOffset < 0 || offsetCharacters.length <= indexInOffset) {
                continue;
            }
            if(indexInOffset + range  <  0){
                newChar = offsetCharacters.length + indexInOffset + range;
            }
            else if(indexInOffset + range >= offsetCharacters.length){
                newChar = -offsetCharacters.length + indexInOffset + range;
            }
            else{
                newChar = indexInOffset + range;
            }
            stringBuilder.setCharAt(i, (char)offsetCharacters[newChar]);
        }
        return stringBuilder;
    }
    public int bruteForceDecrypt(int[] alphabet, String charSequence, String txt){
        int i = 0;
        while (i < alphabet.length) {
            String nextCharSequence = shift(alphabet, i, charSequence).toString();
            if(txt.contains(nextCharSequence)){
                return i;
            }
            i++;
        }
        return Integer.MAX_VALUE;
    }
}

