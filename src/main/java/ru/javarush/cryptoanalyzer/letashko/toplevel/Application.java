package ru.javarush.cryptoanalyzer.letashko.toplevel;

import ru.javarush.cryptoanalyzer.letashko.entity.Result;
import ru.javarush.cryptoanalyzer.letashko.controller.MainController;

import java.util.Arrays;

public class Application {
    private final MainController mainController;

    public Application(MainController mainController) {
        this.mainController = mainController;
    }


    public Result run(String[] args) {

        String command = args[0];
        String[] parameters = Arrays.copyOfRange(args, 1, args.length); //text.txt encoded.txt 45
        return mainController.execute(command,parameters);
    }
}
