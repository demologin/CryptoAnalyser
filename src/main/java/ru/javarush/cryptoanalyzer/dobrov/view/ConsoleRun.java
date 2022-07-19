package ru.javarush.cryptoanalyzer.dobrov.view;

import ru.javarush.cryptoanalyzer.dobrov.exception.ApplicationException;

import java.util.Scanner;

public class ConsoleRun {

    private String command;
  private int key;
    public void runConsole() {
        Scanner scanner = new Scanner(System.in);
        int firstChoice;

        System.out.println("Выберите один из вариантов : ");
        System.out.println("1. Encode.");
        System.out.println("2. Decode.");
        System.out.println("3. BruteForce.");
        System.out.println("4. Analyse. - не удалось пока что сделать.");

        firstChoice = Integer.parseInt(scanner.nextLine());
        switch (firstChoice) {
            case 1 -> {command = "encode";
                extracted(scanner);
            }
            case 2 -> {command = "decode";
                extracted(scanner);
            }
            case 3 -> command = "bruteForce";
            case 4 -> command = "Analyse";
            default ->
                System.out.println("Такой команды нет");

        }


    }

    private void extracted(Scanner scanner) {
        System.out.println("Введите ключ : ");
        try {
            key = Integer.parseInt(scanner.nextLine());
        } catch (RuntimeException e) {
            throw new ApplicationException("Неверно введён ключ");
        }
    }


    public String getCommand() {
        return command;
    }

    public int getKey() {
        return key;
    }
}
