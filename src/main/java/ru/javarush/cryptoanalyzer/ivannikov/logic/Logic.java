package ru.javarush.cryptoanalyzer.ivannikov.logic;

import ru.javarush.cryptoanalyzer.ivannikov.exception.ApplicationException;

import java.util.Scanner;

import static ru.javarush.cryptoanalyzer.ivannikov.actions.BruteForce.bruteForce;
import static ru.javarush.cryptoanalyzer.ivannikov.actions.Decrypt.decrypt;
import static ru.javarush.cryptoanalyzer.ivannikov.actions.Encrypt.encrypt;
import static ru.javarush.cryptoanalyzer.ivannikov.actions.StatisticalAnalysis.statisticalAnalysis;

public class Logic {
    //TODO Coding. Need use OOP here. Many static methods is not best practice.
    public static void logic() {
        try (Scanner scanner = new Scanner(System.in)) {
            int option = scanner.nextInt();
            //TODO Coding. Magic values or methods. Bad reading and understanding
            if (option == 1) {
                encrypt();
            } else if (option == 2) {
                decrypt();
            } else if (option == 3) {
                bruteForce();
            } else if (option == 4) {
                statisticalAnalysis();
            } else if (option == 0) {
                System.out.println("you left the program");
            } else {
                System.out.println("this option is not available");
                System.out.println("try again");
                logic();
            }
        } catch (Exception e) {
            throw new ApplicationException("incorrect input");
        }
    }
}



