package ru.javarush.cryptoanalyzer.belitsky.actions;

import ru.javarush.cryptoanalyzer.belitsky.alphabet.Alphabet;
import ru.javarush.cryptoanalyzer.belitsky.application.Menu;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class mainActions {



    public static void decryptBrutForce(String src, String dest) {
        int key;
        if ((key = Actions2.rollToCheck(src)) == -1) {
            //TODO Coding. We see console (System.out.print) here. Need move the output to View layer
            System.out.println("Брут форс не сработал");
            return;
        }
        Actions2.rollWithKey(src, dest, key);
    }
    public static void decryptWithKey(String src, String dest) {
        int key = Menu.inputKey();
        Actions2.rollWithKey(src, dest, (key * -1));
    }
    public static void decryptStatic(String srcOrig, String src, String dest) {
        HashMap<Character, Character> charsToChange = Actions2.charsToChange(srcOrig, src);
        try (FileReader input = new FileReader(src)) {
            char[] buff = new char[5000];
            while (input.ready()) {
                int buffSize = input.read(buff);
                char[] buffToWrite = new char[buffSize];
                for (int i = 0,j=0; i < buffSize; i++) {
                    char symbol = Character.toLowerCase(buff[i]);
                    if (Alphabet.alphabetContainsCheck(symbol))
                        buffToWrite[j++]=charsToChange.get(symbol);
                }
                Actions2.finalTextWrite(dest,buffToWrite);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
