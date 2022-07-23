package ru.javarush.cryptoanalyzer.parfenov.app;

import ru.javarush.cryptoanalyzer.parfenov.arguments.ArgumentTypes;
import ru.javarush.cryptoanalyzer.parfenov.entity.Result;
import ru.javarush.cryptoanalyzer.parfenov.controller.MainController;

import java.util.Map;

public class Application {
    private final MainController mainController;
    public Application(MainController mainController) {
        this.mainController = mainController;
    }
    public Result run(Map<ArgumentTypes, Object> arguments) {
        return mainController.execute(arguments);
    }
}
