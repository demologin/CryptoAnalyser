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

public class DecryptLogic {

    public static void startToDescrypt(Path pathIn, Path pathOut, int key) {
        try (BufferedReader sourse = Files.newBufferedReader(pathIn);
             BufferedWriter decrypt = Files.newBufferedWriter(pathOut)) {

            while (sourse.ready()) {
                String line = sourse.readLine();
                decrypt.write(decrypt(line, key));
            }
        } catch (IOException e) {
            throw new AppException(ResultCode.ERROR, e.getMessage());
        }

        System.out.println("Decryption is finished!!!");
    }
//расшифровка
    public static String decrypt(String str, int key) {
        List<Character> valueList = new ArrayList<>(Alphabet.alphOriginal.keySet());
        int valueListLenth = valueList.size();
        StringBuilder decryptedString = new StringBuilder();
        char[] line = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            int a = valueList.indexOf(line[i]);
            int KeyNumber = a - (key % valueListLenth);
            if (KeyNumber < 0) {
                KeyNumber = valueListLenth - Math.abs(KeyNumber);
            }
            char decryptSymbol = valueList.get(KeyNumber);
            decryptedString.append(decryptSymbol);
        }
        return decryptedString.toString();
    }
}
