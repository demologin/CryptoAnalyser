package ru.javarush.cryptoanalyzer.tretyakova.service;

import ru.javarush.cryptoanalyzer.tretyakova.util.Alphabet;

public class BruteForceService {

    public DecryptService decryptService;

    public BruteForceService(DecryptService decryptService) {
        this.decryptService = decryptService;
    }

    public int bruteForceDecrypt(String inputFile, String outputFile) {
        for (int i = 0; i < Alphabet.encryptMap.size(); i++) {
            StringBuilder decryptedText = decryptService.decryptFile(inputFile, outputFile, i);
            if (isValid(decryptedText)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isValid(StringBuilder decryptedText) {
        //TODO Coding. Magic values or methods. Bad reading and understanding
        String[] lines = decryptedText.toString().split(" ");
        for (String word : lines) {
            if (word.length() > 30) {
                return false;
            }
        }
        return true;
    }
}






