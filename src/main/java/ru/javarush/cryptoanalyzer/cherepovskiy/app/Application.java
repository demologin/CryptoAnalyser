package ru.javarush.cryptoanalyzer.cherepovskiy.app;

import ru.javarush.cryptoanalyzer.cherepovskiy.controller.Controller;
import ru.javarush.cryptoanalyzer.cherepovskiy.view.Menu;

import java.util.Arrays;

public class Application {
    private final Controller controller;

    public Application() {
        this.controller = new Controller();
    }

    public void run(String[] args) {

        if (args.length == 0) {
            args = new Menu().getFromMenu();
        }
        String command = args[0];
        String[] parametrs = Arrays.copyOfRange(args, 1, args.length);
        controller.execute(command, parametrs);
    }
}
