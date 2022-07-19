package ru.javarush.cryptoanalyzer.kislyakova.view.console;
import ru.javarush.cryptoanalyzer.kislyakova.controller.MainController;
import ru.javarush.cryptoanalyzer.kislyakova.entity.Result;
import ru.javarush.cryptoanalyzer.kislyakova.entity.ResultCode;

import java.util.Arrays;
@SuppressWarnings("ClassCanBeRecord")
public class ConsoleApp {
    private final MainController mainController;
    private final Menu menu;

    public ConsoleApp(MainController mainController, Menu menu) {
        this.mainController = mainController;
        this.menu = menu;
    }

    public void run(String[] args){
        Result result;
        do{
            if(args.length == 0){
                args = menu.getArgs();
            }
            result = getResult(args);
            args = new String[0];
        } while (result.getResultCode() == ResultCode.ERROR);
    }

    private Result getResult(String[] args){
        String action = args[0];
        String[] parameters = Arrays.copyOfRange(args, 1, args.length);
        return mainController.execute(action, parameters);
    }
}
