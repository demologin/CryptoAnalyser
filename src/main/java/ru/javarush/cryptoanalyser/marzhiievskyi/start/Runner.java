package ru.javarush.cryptoanalyser.marzhiievskyi.start;

import ru.javarush.cryptoanalyser.marzhiievskyi.commandSelector.AppOfCommands;
import ru.javarush.cryptoanalyser.marzhiievskyi.controller.MainController;
import ru.javarush.cryptoanalyser.marzhiievskyi.entity.Result;
import ru.javarush.cryptoanalyser.marzhiievskyi.uis.CL_Interface;


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
