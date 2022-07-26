package ru.javarush.cryptoanalyzer.rantsev;

import ru.javarush.cryptoanalyzer.rantsev.console.ConsoleApp;
import ru.javarush.cryptoanalyzer.rantsev.controller.MainController;
import ru.javarush.cryptoanalyzer.rantsev.console.Menu;


import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Menu menu = new Menu(console);
        MainController mainController = new MainController();
        ConsoleApp application = new ConsoleApp(mainController, menu);
        application.run(args);
    }
}
