package ru.javarush.cryptoanalyzer.cherepovskiy.logicpart;

import ru.javarush.cryptoanalyzer.cherepovskiy.constants.Alphabet;
import ru.javarush.cryptoanalyzer.cherepovskiy.entity.ResultCode;
import ru.javarush.cryptoanalyzer.cherepovskiy.exceptions.AppException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class EncryptLogic {
    //TODO Coding. Need use OOP here. Many static methods is not best practice.
    //TODO ---  may be move it just to commands
    public static void prepereToEncrypte(Path pathIn, Path pathOut, int key){
        try (BufferedReader sourse = Files.newBufferedReader(pathIn);
             BufferedWriter encypt = Files.newBufferedWriter(pathOut)) {

            while (sourse.ready()) {
                String line = sourse.readLine();
                encypt.write(encrypt(line, key));
            }
        } catch (IOException e) {
            throw new AppException(ResultCode.ERROR, e.getMessage());
        }

        System.out.println("Encryption is finished!!!");
    }

    //TODO Code style. User russain comments? Bad English is much better than the best Russian comments.
//    дешифровка

    //TODO Coding. Need use OOP here. Many static methods is not best practice.
    public static String encrypt(String str, int key) {
        List<Character> valueList = new ArrayList<>(Alphabet.alphOriginal.keySet());
        int valueListLenth = valueList.size();
        StringBuilder encryptedString = new StringBuilder();
        char[] line = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            int a = valueList.indexOf(line[i]);
            int keyNumber = a + (key % valueListLenth);
            if (keyNumber >= valueListLenth) {
                keyNumber = keyNumber - valueListLenth;
            }
            char encryptedSymbol = valueList.get(keyNumber);
            encryptedString.append(encryptedSymbol);
        }
        return encryptedString.toString();
    }
}
