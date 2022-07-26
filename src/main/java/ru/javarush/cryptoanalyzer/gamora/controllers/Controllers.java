package ru.javarush.cryptoanalyzer.gamora.controllers;

public enum Controllers {

    MAIN_CONTROLLER(new MainController());

    public final Controller controller;

    Controllers(Controller controller) {
        this.controller = controller;
    }

}
