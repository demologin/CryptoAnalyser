package ru.javarush.cryptoanalyzer.gamora.controllers;

import ru.javarush.cryptoanalyzer.gamora.actions.Action;
import ru.javarush.cryptoanalyzer.gamora.actions.ActionFactory;
import ru.javarush.cryptoanalyzer.gamora.actions.Actions;
import ru.javarush.cryptoanalyzer.gamora.app.Localization;
import ru.javarush.cryptoanalyzer.gamora.app.LocalizationEN;
import ru.javarush.cryptoanalyzer.gamora.app.Localizations;
import ru.javarush.cryptoanalyzer.gamora.entity.Result;
import ru.javarush.cryptoanalyzer.gamora.entity.ResultCode;
import ru.javarush.cryptoanalyzer.gamora.exception.CryptoanalyzerApplicationException;
import ru.javarush.cryptoanalyzer.gamora.exception.ExceptionMessages;

import javax.naming.InvalidNameException;

public class MainController implements Controller {

    public Result execute(String command, String[] parameters) {
        ActionFactory actionFactory = new ActionFactory();
        try {
            Action action = actionFactory.getAction(parameters);
            Result result = action.execute();
            result.setAction(Actions.valueOf(command.toUpperCase()));
            return result;
        } catch (IllegalArgumentException e) {
            throw new CryptoanalyzerApplicationException(ExceptionMessages.INVALID_COMMAND.exceptionMessage);
        }
    }

}
