package ru.javarush.cryptoanalyzer.moskvitina;

import ru.javarush.cryptoanalyzer.moskvitina.controller.MainController;
import ru.javarush.cryptoanalyzer.moskvitina.view.console.ConsoleApp;
import ru.javarush.cryptoanalyzer.moskvitina.view.console.Menu;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu(sc);
        MainController mainController = new MainController();
        ConsoleApp app = new ConsoleApp(mainController, menu);
        app.run(args);



    }
}
