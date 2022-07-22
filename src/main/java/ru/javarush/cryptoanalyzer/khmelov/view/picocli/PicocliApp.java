package ru.javarush.cryptoanalyzer.khmelov.view.picocli;

import ru.javarush.cryptoanalyzer.khmelov.controller.MainController;
import ru.javarush.cryptoanalyzer.khmelov.entity.Result;
import ru.javarush.cryptoanalyzer.khmelov.exception.AppException;

import java.util.Arrays;

@SuppressWarnings("ClassCanBeRecord")
public class PicocliApp {

    private final MainController mainController;

    public PicocliApp(MainController mainController) {
        this.mainController = mainController;
    }

    public Result run(String[] args) {
        if (args.length > 0) {
            String action = args[0];
            String[] parameters = Arrays.copyOfRange(args, 1, args.length);
            return mainController.doAction(action, parameters);
        } else
            throw new AppException("no args");
    }
}
