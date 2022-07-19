package ru.javarush.cryptoanalyzer.khlopin.commands;

import ru.javarush.cryptoanalyzer.khlopin.constants.Constants;
import ru.javarush.cryptoanalyzer.khlopin.constants.Dictionary;
import ru.javarush.cryptoanalyzer.khlopin.controller.Controller;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;


public class BruteForce {


    public static void bruteForce(String text) {
        //TODO Coding. We see console (System.out.print) here. Need move the output to View layer
        //TODO Code style. Needs reformat or extraction to methods / variables / constants
        System.out.println("******************************************");
        System.out.println("Выберите метод взлома:");
        System.out.println("1 - Взлом по пунктуации");
        System.out.println("2 - Взлом по словарю");
        System.out.println("******************************************");
        Scanner console = new Scanner(System.in);
        int key = console.nextInt();
        if (key == 1) {
            bruteForceByGrammatical(text);
        } else if (key == 2){
            bruteForceByDictionary(text);
        } else {
            //TODO Code style. Needs reformat or extraction to methods / variables / constants
            System.out.println("Введено неверное значение");
            Controller.run();
        }
    }

    private static void bruteForceByDictionary(String text) {

        char[] charArray = tryToDecrypt(text);
        boolean successful = false;
        while (!successful) {
            String text1 = new String(charArray);
            StringTokenizer tokenizer = new StringTokenizer(text1, " ");
            List<String> textTokenInList = new ArrayList<>();
            while (tokenizer.hasMoreTokens()) {
                textTokenInList.add(tokenizer.nextToken()); // делит стринг на токены по пробелам и добавляет их в список
            }
            for (int i = 0; i < textTokenInList.size(); i++) {
                for (int j = 0; j < Dictionary.dictionary.size(); j++) {
                    if (i > 0 && textTokenInList.get(i).equals(Dictionary.dictionary.get(j))) {
                        successful = true;
                        break;
                    }
                }
            }
            if (!successful) {
                charArray = tryToDecrypt(text);
            }
        }
        writeResultInFile(charArray);

    }

    private static void bruteForceByGrammatical(String text) {

        char[] charArray = tryToDecrypt(text);
        boolean successful = false;
        while (!successful) {
            String text1 = new String(charArray);
            StringTokenizer tokenizer = new StringTokenizer(text1, " ");
            List<String> textTokenInList = new ArrayList<>();
            while (tokenizer.hasMoreTokens()) {
                textTokenInList.add(tokenizer.nextToken()); // делит стринг на токены по пробелам и добавляет их в список
            }
            for (int i = 0; i < textTokenInList.size(); i++) {
                for (int j = 0; j < Dictionary.introductoryWords.size(); j++) {
                    if (i > 0 && textTokenInList.get(i).equals(Dictionary.introductoryWords.get(j)) && textTokenInList.get(i - 1).endsWith(",")) {
                        successful = true;
                        break;
                    }
                }
            }
            if (!successful) {
                charArray = tryToDecrypt(text);
            }
        }
        writeResultInFile(charArray);

    }


    private static char[] tryToDecrypt(String text) {
         Random random = new Random();
        int key = random.nextInt(Constants.getALPHABET().size());
        System.out.println("Пробуем ключ " + key);
        char[] charArray = text.toCharArray();

        for (int i = 0; i < text.length(); i++) {
            int temp = Constants.getALPHABET().indexOf(text.charAt(i)); // Получаем индекс символа в алфавите из входящего текста
            if (temp - key < 0) {
                int test = temp - key;
                charArray[i] = Constants.getALPHABET().get(Constants.getALPHABET().size() + test);
            } else {
                charArray[i] = Constants.getALPHABET().get((temp - key) % (Constants.getALPHABET().size()));
            }
        }
        return charArray;
    }

    private static void writeResultInFile(char[] charArray) {
        final ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode(CharBuffer.wrap(charArray));
        byte[] result = Arrays.copyOf(byteBuffer.array(), byteBuffer.limit());

        try {
            Files.write(Constants.getOriginalText(), result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}