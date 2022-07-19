package ru.javarush.cryptoanalyser.kislyakova.view;
import ru.javarush.cryptoanalyser.kislyakova.controller.MainController;
import ru.javarush.cryptoanalyser.kislyakova.view.console.ConsoleApp;
import ru.javarush.cryptoanalyser.kislyakova.view.console.Menu;

import java.util.Scanner;

public class ConsoleRunner {
    //draft view
    public static void main(String[] args) {
        //build console app
        Scanner scan = new Scanner(System.in);
        Menu menu = new Menu(scan);
        MainController mainController = new MainController();
        ConsoleApp consoleApp = new ConsoleApp(mainController, menu);
        //run console app
        consoleApp.run(args);
    }
}
