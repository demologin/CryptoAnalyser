package ru.javarush.cryptoanalyzer.stepin.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static ru.javarush.cryptoanalyzer.stepin.constants.Strings.alphabetLength;

public class BruteForse implements Action {
    private static final Scanner scanner;
    private static final Decoder decoder;

    static {
        scanner = new Scanner(System.in);
        decoder = new Decoder();
    }

    @Override
    public void execute() throws IOException {
        //TODO Code style. Long code. Needs to be split into several methods
        //TODO Coding. We see console (System.out.print) here. Need move the output to View layer
        System.out.println("Введите полный путь к файлу, для его расшифровки:");
        String pathEncryptedFile = scanner.nextLine();

        System.out.println("Введите полный путь к файлу, в который записать расшифрованый текст:");
        String pathNotEncryptedFile = scanner.nextLine();

        try (var reader = Files.newBufferedReader(Paths.get(pathEncryptedFile));
             var writer = Files.newBufferedWriter(Paths.get(pathNotEncryptedFile))) {

            StringBuilder stringBuilder = new StringBuilder();
            ArrayList<String> listStrings = new ArrayList<>();

            while (reader.ready()) {
                String string = reader.readLine();
                stringBuilder.append(string);
                listStrings.add(string);
            }

            for (int i = 0; i < alphabetLength(); i++) {
                String deEncrypt = decoder.deEncrypt(stringBuilder.toString(), i);
                if (isValidateText(deEncrypt)) {
                    for (String listString : listStrings) {
                        String encrypt = decoder.deEncrypt(listString, i);
                        writer.write(encrypt + System.lineSeparator());
                    }
                    System.out.println("Содержимое файла расшифровано методом перебора ключей. Ключ расшифровки K = " + i);
                    break;
                }
            }
        }
    }

    private static boolean isValidateText(String text) {
        //TODO Code style. Long code. Needs to be split into several methods
        boolean isValidate = false;

        int indexStart = new Random().nextInt(text.length() / 2);
        String substring = text.substring(indexStart, indexStart + (int) Math.sqrt(text.length()));

        String[] words = substring.split(" ");
        for (String word : words) {
            if (word.length() > 24) {
                return false;
            }
        }
        if (substring.contains(". ") || substring.contains(", ") || substring.contains("! ") || substring.contains("? ")) {
            isValidate = true;
        }
        while (isValidate) {
            System.out.println(substring);
            //TODO Coding. We see console (System.out.print) here. Need move the output to View layer
            System.out.println("Понятин ли вам этот текст? Y/N");

            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("Y")) {
                return true;
            } else if (answer.equalsIgnoreCase("N")) {
                isValidate = false;
            } else {
                //TODO Coding. We see console (System.out.print) here. Need move the output to View layer
                //TODO Coding. Magic values or methods. Bad reading and understanding
                System.out.println("выберете только между Y/N");
            }
        }
        return false;
    }
}
