package ru.javarush.cryptoanalyzer.moskvitina.util;

import static ru.javarush.cryptoanalyzer.moskvitina.constants.Dictionary.charList;

public class KeyCalculator {

    public static int getKey(int key, int size) {

        int evenPart = key / size;
        return Math.abs(evenPart * size - key);
    }

    public static int getKey(String str){
        int key = 0;
        for (int i = 1; i < charList.size(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if (j != str.length() - 1 && i != charList.size() - 1) {
                    int currentPosition = charList.indexOf(str.charAt(j));
                    int nextPosition = charList.indexOf(str.charAt(j + 1));
                    int newPosition1 = Math.abs((currentPosition + (charList.size() - (i % charList.size()))) % charList.size());
                    int newPosition2 = Math.abs((nextPosition + (charList.size() - (i % charList.size()))) % charList.size());
                    char decryptedLetter1 = charList.get(newPosition1);
                    char decryptedLetter2 = charList.get(newPosition2);
                    if (decryptedLetter1 == 44 && decryptedLetter2 == 32) {
                        key = i;
                        break;
                    }
                }
            }
            if(key == i){
                break;
            }
        }
        return key;
    }
}
