package ru.javarush.cryptoanalyser.moskvitina;

import ru.javarush.cryptoanalyser.moskvitina.controller.MainController;
import ru.javarush.cryptoanalyser.moskvitina.view.console.ConsoleApp;
import ru.javarush.cryptoanalyser.moskvitina.view.console.Menu;

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
