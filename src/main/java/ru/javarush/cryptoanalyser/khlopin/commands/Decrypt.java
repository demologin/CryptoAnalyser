package ru.javarush.cryptoanalyser.khlopin.commands;

import ru.javarush.cryptoanalyser.khlopin.constants.Constants;
import ru.javarush.cryptoanalyser.khlopin.exception.ApplicationException;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;

public class Decrypt  {

    public static void decrypt(String text, int key) {
        char[] charArray = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            int temp = Constants.getALPHABET().indexOf(text.charAt(i)); // Получаем индекс символа в алфавите из входящего текста
            if (temp - key < 0) {
                int negativeTemp = temp - key;
                charArray[i] = Constants.getALPHABET().get(Constants.getALPHABET().size() + negativeTemp);
            } else {
                charArray[i] = Constants.getALPHABET().get((temp - key) % (Constants.getALPHABET().size()));
            }
        }

        writeResultInFile(charArray);

    }

    private static void writeResultInFile(char[] charArray) {
        final ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode(CharBuffer.wrap(charArray));
        byte[] result = Arrays.copyOf(byteBuffer.array(), byteBuffer.limit());

        try {
            Files.write(Constants.getOriginalText(), result);
        } catch (IOException e) {
            throw new ApplicationException(e.getMessage());
        }
    }
}
