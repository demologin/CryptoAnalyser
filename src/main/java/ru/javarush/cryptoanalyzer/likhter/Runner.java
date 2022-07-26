package ru.javarush.cryptoanalyzer.likhter;

import ru.javarush.cryptoanalyzer.likhter.toplevel.CommandBuilder;
import ru.javarush.cryptoanalyzer.likhter.controller.MainController;
import ru.javarush.cryptoanalyzer.likhter.entity.Result;
import ru.javarush.cryptoanalyzer.likhter.toplevel.InputOptions;

public class Runner {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        CommandBuilder commandBuilder = new CommandBuilder(mainController);
        Result result;
        if (args.length == 0) {
            result = commandBuilder.run(InputOptions.options());
        } else {
            result = commandBuilder.run(args);
        }
        System.out.println(result);
    }
}