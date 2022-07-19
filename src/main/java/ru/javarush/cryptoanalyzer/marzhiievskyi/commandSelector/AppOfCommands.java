package ru.javarush.cryptoanalyzer.marzhiievskyi.commandSelector;

import ru.javarush.cryptoanalyzer.marzhiievskyi.controller.MainController;
import ru.javarush.cryptoanalyzer.marzhiievskyi.entity.Result;

import java.util.Arrays;

public class AppOfCommands {
    //TODO ---  packagename is a bomb
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
