package ru.javarush.cryptoanalyzer.gamora.app;

public enum Localizations {
    EN(LocalizationEN.localizationEN);
    
    public final Localization localization;

    Localizations(Localization localization) {
        this.localization = localization;
    }
}
