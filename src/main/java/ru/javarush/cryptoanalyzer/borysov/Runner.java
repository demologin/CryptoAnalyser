package ru.javarush.cryptoanalyzer.borysov;


import ru.javarush.cryptoanalyzer.borysov.contoller.MainController;
import ru.javarush.cryptoanalyzer.borysov.view.Console;

public class Runner {
    public static void main(String[] args) {
        String command = Console.run();
        MainController mainController = new MainController();
        String result = mainController.extracted(command);
        System.out.println(result);
    }
}
