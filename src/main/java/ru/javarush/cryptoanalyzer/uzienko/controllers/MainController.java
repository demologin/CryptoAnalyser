package ru.javarush.cryptoanalyzer.uzienko.controllers;

import ru.javarush.cryptoanalyzer.uzienko.commands.Action;
import ru.javarush.cryptoanalyzer.uzienko.entity.Result;
import ru.javarush.cryptoanalyzer.uzienko.entity.ResultCode;
import ru.javarush.cryptoanalyzer.uzienko.exceptions.ApplicationException;

import java.util.Arrays;

public class MainController implements AppController {
    @Override
    public Result execute(String[] args) {
        String command = args[0];
        String[] parameters = Arrays.copyOfRange(args, 1, args.length);
        try {
            Action action = Actions.find(command);
            return action.execute(parameters);
        } catch (ApplicationException e) {
            return new Result(ResultCode.ERROR, e.getMessage());
        }
    }
}
