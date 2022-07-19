package ru.javarush.cryptoanalyser.marzhiievskyi.commandSelector;

import ru.javarush.cryptoanalyser.marzhiievskyi.controller.MainController;
import ru.javarush.cryptoanalyser.marzhiievskyi.entity.Result;

import java.util.Arrays;

public class AppOfCommands {
    private final MainController mainController;

    public AppOfCommands(MainController mainController) {
        this.mainController = mainController;
    }

    public Result run(String[] args) {
        String command = args[0];
        String[] parameters = Arrays.copyOfRange(args, 1, args.length);
        return mainController.execute(command, parameters);
    }
}
