package ru.javarush.cryptoanalyzer.afonin.view.console;

import ru.javarush.cryptoanalyzer.afonin.controller.MainController;
import ru.javarush.cryptoanalyzer.afonin.entity.Result;

import java.util.Arrays;


public class ConsoleApp {

    private final MainController mainController;

    private final Menu menu;

    public ConsoleApp(MainController mainController, Menu menu) {
        this.mainController = mainController;
        this.menu = menu;
    }

    public void run(String[] args) {
        String[] argsConsole = menu.run();
        String command = argsConsole[0];
        String[] parametrs = Arrays.copyOfRange(argsConsole, 1, argsConsole.length);
        Result result = mainController.execute(command, parametrs);
        System.out.println(result);
    }
}