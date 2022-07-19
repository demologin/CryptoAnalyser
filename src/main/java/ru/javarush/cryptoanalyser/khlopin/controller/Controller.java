package ru.javarush.cryptoanalyser.khlopin.controller;

import ru.javarush.cryptoanalyser.khlopin.commands.BruteForce;
import ru.javarush.cryptoanalyser.khlopin.commands.Decrypt;
import ru.javarush.cryptoanalyser.khlopin.commands.Encrypt;
import ru.javarush.cryptoanalyser.khlopin.constants.Resources;
import ru.javarush.cryptoanalyser.khlopin.exception.ApplicationException;

import java.util.Scanner;

public class Controller {

    public static void init() {
        System.out.println("**************************************************");
        System.out.println("Добро пожаловать в КриптоАнализатор!");
        System.out.println("**************************************************");
    }
    public static void run() {
        preview();
        Scanner console = new Scanner(System.in);
        System.out.print("Введите цифру: ");
        int activator = console.nextInt();
        switch (activator) {
            case 1 -> {
                System.out.println("Выберите метод ввода текста");
                System.out.println("1 - Ввести текст через файл (Необходимо на этом этапе записать текст для шифровки в файл text.txt)");
                System.out.println("2 - Ввести текст через консоль и записать в файл.");
                int choose = console.nextInt();
                if (choose == 1) {
                    Encrypt.crypt(Resources.getTextFromFile(), Resources.getKey());
                    System.out.println("Результат записан в файл crypt.txt");
                } else if (choose == 2) {
                    Encrypt.crypt(Resources.getTextFromConsole(), Resources.getKey());
                    System.out.println("Результат шифровки: " + Resources.getTextCrypt());
                } else {
                    finish(console);
                }
            }
            case 2 -> {
                Decrypt.decrypt(Resources.getTextCrypt(), Resources.getKey());
                System.out.println("Результат дешифровки: " + Resources.getTextDecrypt());
                System.out.println("Полный результат дешифровки находится в файле originalText.txt");
            }
            case 3 -> {
                BruteForce.bruteForce(Resources.getTextCrypt());
                System.out.println("Результат взлома: " + Resources.getTextDecrypt());
                System.out.println("Полный результат взлома находится в файле originalText.txt");
            }
            case 4 -> System.out.println("Последний зашифрованный текст: " + Resources.getTextCrypt());
            case 5 -> System.out.println("Последний расшифрованный/взломанный текст: " + Resources.getTextDecrypt());
            case 6 -> System.out.println("Последний введённый текст: " + Resources.getTextFromFile());
            case 7 -> {
                System.out.println("Всё. Я ухожу.");
                System.exit(0);
            }
            default -> {
                System.out.println("Введено неправильно значение");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new ApplicationException(e.getMessage());
                }
                run();
            }
        }


        finish(console);
    }

    private static void preview() {
        System.out.println("--------------------------------------------------");
        System.out.println("Выберите функцию: ");
        System.out.println("1. Зашифровать текст.");
        System.out.println("2. Расшифровать текст.");
        System.out.println("3. BruteForce");
        System.out.println("--------------------------------------------------");
        System.out.println("4. Посмотреть последний зашифрованный текст");
        System.out.println("5. Посмотреть последний расшифрованный текст");
        System.out.println("6. Посмотреть последний введённый текст");
        System.out.println("--------------------------------------------------");
        System.out.println("7. Закрыть программу");
        System.out.println("--------------------------------------------------");
    }

    private static void finish(Scanner console) {
        int activator;
        System.out.println("1 - Меню");
        System.out.println("Для закрытия программы - любой текст или нажмите enter");
        activator = console.nextInt();
        System.out.print("Введите: ");
        if (activator == 1) {
            run();
        } else {
            System.out.println("Всё. Я ухожу.");
            System.exit(0);
        }
    }
}
