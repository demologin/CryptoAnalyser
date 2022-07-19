package ru.javarush.cryptoanalyzer.khlopin.constants;

import ru.javarush.cryptoanalyzer.khlopin.exception.ApplicationException;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class Resources {
    //TODO Code style. Need use OOP here. Many static methods is not best practice.
    //TODO Code style. Need use private constructor in static context.
    //TODO ---  package const, really? Why?
    public static String getTextCrypt() { // получить зашифрованный текст
        try {
            if (Files.exists(Constants.getCryptText())) {
               String textString = String.valueOf(Files.readAllLines(Constants.getCryptText()));
                if (!textString.isEmpty()) {
                    return textString.substring(1, textString.length() - 1).toLowerCase();
                } else {
                    throw new ApplicationException("Текст отсутствует в файле");
                }
            } else {
                throw new ApplicationException("Файла не существует");
            }
        } catch (IOException e) {
            throw new ApplicationException();
        }
    }

    //TODO Code style. User russian comments? Bad English is much better than the best Russian comments.
    public static String getTextDecrypt() { // получить расшифрованный текст
        try {
            if (Files.exists(Constants.getOriginalText())) {
               String textString = String.valueOf(Files.readAllLines(Constants.getOriginalText()));
                if (!textString.isEmpty()) {
                    return textString.substring(1, textString.length() - 1);
                } else {
                    throw new ApplicationException("Текст отсутствует в файле");
                }
            }
        } catch (IOException e) {
            throw new ApplicationException("Файла не существует");
        }
        return null;
    }

    public static String getTextFromConsole() { // получить обычный текст из консоли
        Scanner console = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String text = console.nextLine();
        try {
            Files.writeString(Constants.getText(), text);
        } catch (IOException e) {
            throw new ApplicationException(e.getMessage());
        }
        return text.toLowerCase();
    }

    public static String getTextFromFile() { // получить обычный текст из файла
        try {
            if (Files.exists(Constants.getText())) {
              String textString = String.valueOf(Files.readAllLines(Constants.getText()));
                if (!textString.isEmpty()) {
                    return textString.substring(1, textString.length() - 1).toLowerCase();
                } else {
                    throw new ApplicationException("Текст отсутствует в файле");
                }
            } else {
                throw new ApplicationException("Файла не существует");
            }
        } catch (IOException e) {
            throw new ApplicationException();
        }
    }

    public static int getKey() { // установить значение смещения
        Scanner console = new Scanner(System.in);
        System.out.print("Введите ключ шифрования: ");
        while (true) {
            int key = console.nextInt();
            if (key <= Constants.getALPHABET().size() - 1 && key >= 0) {
                return key;
            } else {
                System.out.println("Введите ключ в пределах длинны алфавита");
                getKey();
            }
        }
    }
}
