package ru.javarush.cryptoanalyzer.afonin;

import ru.javarush.cryptoanalyzer.afonin.controller.MainController;
import ru.javarush.cryptoanalyzer.afonin.view.console.ConsoleApp;
import ru.javarush.cryptoanalyzer.afonin.view.console.Menu;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu(input);
        MainController mainController = new MainController();
        ConsoleApp application = new ConsoleApp(mainController, menu);
        application.run(args);
    }
}
