package ru.javarush.cryptoanalyzer.marzhiievskyi.start;

import ru.javarush.cryptoanalyzer.marzhiievskyi.commandSelector.AppOfCommands;
import ru.javarush.cryptoanalyzer.marzhiievskyi.controller.MainController;
import ru.javarush.cryptoanalyzer.marzhiievskyi.entity.Result;
import ru.javarush.cryptoanalyzer.marzhiievskyi.uis.CL_Interface;


public class Runner {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        AppOfCommands commandSelector = new AppOfCommands(mainController);
        Result result;

        if (args.length == 0) {
            result = commandSelector.run(CL_Interface.gettingUserParametersWithCL());
        } else {
            result = commandSelector.run(args);
        }

        System.out.println(result);
    }
}
