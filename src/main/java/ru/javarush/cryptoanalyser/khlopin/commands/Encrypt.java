package ru.javarush.cryptoanalyser.khlopin.commands;

import ru.javarush.cryptoanalyser.khlopin.constants.Constants;
import ru.javarush.cryptoanalyser.khlopin.exception.ApplicationException;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;

public class Encrypt {

    public static void crypt(String text, int key) { //метод шифрования
            char[] charArray = text.toCharArray();
            for (int i = 0; i < text.length(); i++) {
                int temp = Constants.getALPHABET().indexOf(text.charAt(i)); // Получаем индекс символа в алфавите из входящего текста
                charArray[i] = Constants.getALPHABET().get((temp + key) % (Constants.getALPHABET().size()));
            }

        writeResultInFile(charArray);

    }

    private static void writeResultInFile(char[] charArray) {
        final ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode(CharBuffer.wrap(charArray));
        byte[] result =  Arrays.copyOf(byteBuffer.array(), byteBuffer.limit());

        try {
            Files.write(Constants.getCryptText(),result);
        } catch (IOException e) {
            throw new ApplicationException(e.getMessage());
        }
    }
}
