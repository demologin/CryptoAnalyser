package ru.javarush.cryptoanalyzer.gamora.app;

import ru.javarush.cryptoanalyzer.gamora.actions.Action;
import ru.javarush.cryptoanalyzer.gamora.actions.Actions;

public final class LocalizationEN implements Localization {
    public static final LocalizationEN localizationEN = new LocalizationEN();
    private LocalizationEN() {
    }

    @Override
    public String getSuccessMessage(Actions action) {
        String successMessage = action.toString() + "_SUCCESS";
        return ENMessages.valueOf(successMessage).message;
    }

    @Override
    public String getFailMessage(Actions action) {
        String successMessage = action.toString() + "_FAIL";
        return ENMessages.valueOf(successMessage).message;
    }

    @Override
    public String getStartMessage() {
        return ENMessages.START.message;
    }
}
