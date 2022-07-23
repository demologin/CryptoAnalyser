package ru.javarush.cryptoanalyzer.cherepovskiy.logicpart;

import ru.javarush.cryptoanalyzer.cherepovskiy.constants.Alphabet;
import ru.javarush.cryptoanalyzer.cherepovskiy.entity.ResultCode;
import ru.javarush.cryptoanalyzer.cherepovskiy.exceptions.AppException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BruteForceLogic {

    public static void startToBruteForce(Path encryptedFile, Path decryptedFile) {
        try (BufferedReader source = Files.newBufferedReader(encryptedFile);
             BufferedWriter decrypt = Files.newBufferedWriter(decryptedFile)) {

            StringBuilder text = new StringBuilder();
            while (source.ready()) {
                String line = source.readLine();
                text.append(line);
            }
// переборка ключей для дешифровки используем метод DecryptLogic.decrypt(), если корректно (encryptCorrect is true) прерываем цикл
            for (int i = 0; i < Alphabet.alphOriginal.size(); i++) {
                String decode = DecryptLogic.decrypt(text.toString(), i);
                BruteForceCheck.encryptIsTrue(decode);
                if (BruteForceCheck.encryptCorrect.equals(true)) {
                    decrypt.write(decode);
                    break;
                }
            }
        } catch (IOException e) {
            throw new AppException(ResultCode.ERROR, e.getMessage());
        }

        System.out.println("Decryption by Brut force is finished!");
    }
}
