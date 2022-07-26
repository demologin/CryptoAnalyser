package ru.javarush.cryptoanalyzer.belitsky.application;

import ru.javarush.cryptoanalyzer.belitsky.actions.Actions3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public enum Menu {
    ENCRYPT, DECRYPT_WITH_KEY, DECRYPT_BRUTFORCE, DECRYPT_STATISTIC, EXIT;


    public static String source;
    public static String destination;
    public static String origDestination;
    public static final String standartDestination = "text1.txt";
    public static final String standartSource = "text.txt";
    public static final String standartOrig = "textOrig.txt";
    public static final String SOMETHING_WENT_WRONG = "Ой, чтото пошло не так. :'(";
    public static final String INPUT_SOURCE_ADRESS = "Введите адрес исходного файла или ENTER, по умолчанию " + standartSource + " : ";
    public static final String INPUT_DEST_ADRESS = "Введите адреc результата, если его не существует он будет создан или ENTER, по умолчанию " + standartDestination + " : ";
    public static final String INPUT_ORIG_ADRESS = "Введите адрес оригинального текста для подсчета статистики или ENTER, по умолчанию " + standartOrig + " : ";
    public static final String INPUT_COMMAND = "Введите команду или ее номер в строку : ";
    public static final String INPUT_KEY = "Введите ключ : ";
    public static final String RESULT_AT = "Результат находится по адресу ";
    public static final String END = "Программа завершена";

    public static void printMenu() {

        for (Menu value : Menu.values()) {
            System.out.println(value.ordinal() + "  " + value);
        }
    }

    //TODO Code style. Use Russian comments? Bad English is much better than the best Russian comments.
    public static Menu menuNavigation() {//навигация по меню.
        while (true) {
            System.out.println(INPUT_COMMAND);
            Scanner scanner = new Scanner(System.in);
            String choise = scanner.nextLine();
            if (Actions3.isNumber(choise) && Integer.parseInt(choise) >= 0 && Integer.parseInt(choise) < Menu.values().length) {
                for (Menu value : Menu.values()) {
                    if (value.ordinal() == Integer.parseInt(choise)) return value;
                }
            } else {
                for (Menu value : Menu.values()) {
                    if (choise.equalsIgnoreCase(value.name())) return value;
                }
            }
            System.out.println(SOMETHING_WENT_WRONG);
        }
    }

    //TODO Coding. Need use OOP here. Many static methods is not best practice.
    private static Path pathAsk(String message, String standart) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("")) input = standart;
        Path path = Path.of(input);
        if (!path.isAbsolute()) path = Path.of(input).toAbsolutePath();
        return path;
    }

    //TODO Code style. Long code. Needs to be split into several methods
    public static void filePathCheck(Menu menuChoise) {
        while (true) {
            Path pathSrc = pathAsk(INPUT_SOURCE_ADRESS, standartSource);
            source = String.valueOf(pathSrc);
            if (Files.notExists(pathSrc)) {
                System.out.println(SOMETHING_WENT_WRONG);
                continue;
            }
            Path pathDest = pathAsk(INPUT_DEST_ADRESS, standartDestination);
            destination = String.valueOf(pathDest);
            if (Files.exists(pathDest)) {
                try {
                    Files.delete(pathDest);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                Files.createFile(pathDest);
                if (menuChoise.equals(Menu.DECRYPT_STATISTIC)) {
                    while (true) {
                        Path origSrc = pathAsk(INPUT_ORIG_ADRESS, standartOrig);
                        origDestination = String.valueOf(origSrc);
                        if (Files.notExists(origSrc)) {
                            System.out.println(SOMETHING_WENT_WRONG);
                            continue;
                        }
                        break;
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            break;
        }
    }

    //TODO Coding. Need use OOP here. Many static methods is not best practice.
    public static int inputKey() {
        while (true) {
            System.out.println(INPUT_KEY);
            Scanner scanner = new Scanner(System.in);
            String key = scanner.nextLine();
            if (!Actions3.isNumber(key)) {
                System.out.println(SOMETHING_WENT_WRONG);
            } else return Integer.parseInt(key);
        }
    }
}
