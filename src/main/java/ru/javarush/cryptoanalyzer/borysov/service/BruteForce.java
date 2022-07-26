package ru.javarush.cryptoanalyzer.borysov.service;

import java.nio.file.Path;
public class BruteForce {


    public static String brute(Path pathInputFile, Path pathOutputFile) {
        //TODO Code style. Use Russian comments? Bad English is much better than the best Russian comments.
        //Этот метод корректно не работает.

        for (int i = 1; i < 34; i++) {
            String i2= String.valueOf(i);
            Path path2 = Path.of((i2+pathOutputFile.getFileName()));
            Decode.decoder(pathInputFile,path2,i);
        }

        //TODO Coding. Need use OOP here. Many static methods is not best practice.
        return "Пока что функция работает только так \nОдин из файлов точно подойдет! ";

    }
}
