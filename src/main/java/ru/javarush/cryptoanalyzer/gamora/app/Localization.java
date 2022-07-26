package ru.javarush.cryptoanalyzer.gamora.app;

import ru.javarush.cryptoanalyzer.gamora.actions.Action;
import ru.javarush.cryptoanalyzer.gamora.actions.Actions;

public interface Localization {
    String getSuccessMessage (Actions action);
    String getFailMessage (Actions action);
    String getStartMessage ();
}
