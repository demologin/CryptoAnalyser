package ru.javarush.cryptoanalyzer.kurchavov.app;

import ru.javarush.cryptoanalyzer.kurchavov.entity.Result;
import ru.javarush.cryptoanalyzer.kurchavov.controller.MainController;
import ru.javarush.cryptoanalyzer.kurchavov.entity.ResultCode;

import java.io.IOException;
import java.util.Arrays;

public class Application {
    private final MainController mainController;

    public Application(MainController mainController) {
        this.mainController = mainController;
    }

    public Result run(String[] args) throws IOException, IllegalAccessException {
        if (args.length==0)
            return new Result(ResultCode.ERROR, "empty args");
        String command = args[0];
        String[] parameters = Arrays.copyOfRange(args, 1, args.length);
        return mainController.execute(command, parameters);
    }
}
