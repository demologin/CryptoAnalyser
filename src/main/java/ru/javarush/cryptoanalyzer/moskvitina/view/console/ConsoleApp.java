package ru.javarush.cryptoanalyzer.moskvitina.view.console;

import ru.javarush.cryptoanalyzer.moskvitina.controller.MainController;
import ru.javarush.cryptoanalyzer.moskvitina.entity.Result;
import ru.javarush.cryptoanalyzer.moskvitina.entity.ResultCode;

import java.util.Arrays;

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
            print(result);
            args = new String[0];

        } while (result.getResultCode() == ResultCode.ERROR || result.getResultCode() == ResultCode.OK);
    }

    private Result getResult(String[] args){
        String command = args[0];
        String[] parameters = Arrays.copyOfRange(args, 1, args.length);
        return mainController.execute(command, parameters);
    }

    private void print(Result result) {
        String message = switch (result.getResultCode()) {
            case OK -> String.format(Messages.OK_FORMAT, result.getMessage());
            case ERROR -> String.format(Messages.ERR_FORMAT, result.getMessage());
        };
        System.out.println(message);
    }
}
