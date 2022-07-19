package ru.javarush.cryptoanalyser.sternard.application.actions;

import ru.javarush.cryptoanalyser.sternard.application.EncryptDecrypt;
import ru.javarush.cryptoanalyser.sternard.application.ReaderWriter;
import ru.javarush.cryptoanalyser.sternard.result.Result;
import ru.javarush.cryptoanalyser.sternard.result.ResultCode;
import ru.javarush.cryptoanalyser.sternard.util.PathFinder;

import static ru.javarush.cryptoanalyser.sternard.constant.Alphabet.ALPHABET;
import static ru.javarush.cryptoanalyser.sternard.constant.Alphabet.ALPHABET_LENGTH;
import static ru.javarush.cryptoanalyser.sternard.constant.language.English.*;
import static ru.javarush.cryptoanalyser.sternard.util.PathFinder.getTextDirectory;

public class Decrypt extends EncryptDecrypt {
    public void resultEncryptDecrypt(int j, int key) {
        textOut.append(ALPHABET[((j - key) + ALPHABET_LENGTH) % ALPHABET_LENGTH]);
    }

    @Override
    public Result returnExecute(String[] params) {
        String fileName1 = params[1];
        String fileName2 = params[2];
        int key = Integer.parseInt(params[3]);
        if (key > ALPHABET_LENGTH)
            return new Result(ResultCode.FAILED, KEY_HIGHER_ALPHABET + ALPHABET_LENGTH);
        ReaderWriter readerWriter = new ReaderWriter();
        String text = doEncryptDecrypt(
                readerWriter.reader(PathFinder.getTextDirectory() + fileName1), key);

        if (readerWriter.writer(getTextDirectory() + fileName2, text, false))
            return new Result(ResultCode.OK, DECRYPTED);
        else
            return new Result(ResultCode.FAILED, NOT_DECRYPTED);
    }
}
