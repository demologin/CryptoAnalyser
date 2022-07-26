package ru.javarush.cryptoanalyzer.gamora.controllers;

public class ControllerFactory {

    public ControllerFactory(String[] args) {
    }

    public Controller getController() {
        return Controllers.MAIN_CONTROLLER.controller;
    }
}
