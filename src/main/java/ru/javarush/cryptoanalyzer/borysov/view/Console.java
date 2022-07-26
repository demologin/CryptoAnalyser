package ru.javarush.cryptoanalyzer.borysov.view;

import java.nio.file.Path;
import java.util.Scanner;

public class Console {
    public Console() {

    }

    static Scanner scanner = new Scanner(System.in);


    public static String run() {
        System.out.println("Выберите один из вариантов : ");
        System.out.println("1. Encode");
        System.out.println("2. Decode");
        System.out.println("3. BruteForce");
        return scanner.nextLine();
    }

    public static Path encodePathView() {
        System.out.println("Введите путь файла, который нужно закодировать: ");
        return Path.of(scanner.nextLine());
    }

    public static int encodePath() {
        System.out.println("Введите ключ:");
        return scanner.nextInt();
    }


    public static Path decodePathView() {
        System.out.println("Введите путь файла, который нужно раскодировать:");
        return Path.of(scanner.nextLine());
    }

    public static int decodePath() {
        System.out.println("Введите ключ:");
        return scanner.nextInt();
    }

    public static Path loadFile() {
        System.out.println("Введите путь файла, куда нужно сохранить файл");
        return Path.of(scanner.nextLine());
    }
}
