package ru.javarush.cryptoanalyzer.likhter.toplevel;

import ru.javarush.cryptoanalyzer.likhter.entity.Result;
import ru.javarush.cryptoanalyzer.likhter.controller.MainController;
import java.util.Arrays;

public class CommandBuilder {
    private final MainController mainController;
    public CommandBuilder(MainController mainController) {
        this.mainController = mainController;
    }

    public Result run(String[] args) {
        String command = args[0];
        String [] parameters = Arrays.copyOfRange(args, 1, args.length);
        return mainController.execute(command, parameters);
    }
}
