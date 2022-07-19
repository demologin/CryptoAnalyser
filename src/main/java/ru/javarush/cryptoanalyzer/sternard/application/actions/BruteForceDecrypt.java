package ru.javarush.cryptoanalyzer.sternard.application.actions;

import ru.javarush.cryptoanalyzer.sternard.application.ReaderWriter;
import ru.javarush.cryptoanalyzer.sternard.application.doAction;
import ru.javarush.cryptoanalyzer.sternard.result.Result;
import ru.javarush.cryptoanalyzer.sternard.result.ResultCode;
import ru.javarush.cryptoanalyzer.sternard.util.PathFinder;

import static ru.javarush.cryptoanalyzer.sternard.constant.Alphabet.ALPHABET_LENGTH;
import static ru.javarush.cryptoanalyzer.sternard.constant.language.English.DECRYPTED;
import static ru.javarush.cryptoanalyzer.sternard.constant.language.English.NOT_DECRYPTED;
import static ru.javarush.cryptoanalyzer.sternard.util.PathFinder.getTextDirectory;

public class BruteForceDecrypt implements doAction {
    @Override
    public Result returnExecute(String[] params) {
        String fileName1 = params[1];
        String fileName2 = params[2];
        int key = 0;

        ReaderWriter readerWriter = new ReaderWriter();
        Decrypt decrypt = new Decrypt();

        String text = readerWriter.reader(PathFinder.getTextDirectory() + fileName1);
        String textSubstr = text.substring(0, text.length() % 5000);
        long textSubstrLength = textSubstr.length();

        while (key < ALPHABET_LENGTH) {
            String textSubstrings = decrypt.doEncryptDecrypt(textSubstr, key);
            long countOfSymbols = textSubstrings.chars().filter(ch -> ch == ' ').count();

            if (countOfSymbols > textSubstrLength / 10) {
                String decryptedText = decrypt.doEncryptDecrypt(text, key);
                readerWriter.writer(getTextDirectory() + fileName2, decryptedText, false);
                return new Result(ResultCode.OK, DECRYPTED);
            }
            key++;
        }
        return new Result(ResultCode.FAILED, NOT_DECRYPTED);
    }
}