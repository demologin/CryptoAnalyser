package ru.javarush.cryptoanalyzer.gamora.app;

import ru.javarush.cryptoanalyzer.gamora.controllers.Controller;
import ru.javarush.cryptoanalyzer.gamora.controllers.ControllerFactory;
import ru.javarush.cryptoanalyzer.gamora.entity.Result;

import java.io.PrintStream;

public abstract class Application {

    protected Controller controller;
    protected String[] args;
    protected final PrintStream messageStream;

    protected Application(PrintStream messageStream) {
        this.messageStream = messageStream;
    }

    public abstract void run();

    protected Controller getController(String[] args) {
        ControllerFactory controllerFactory = new ControllerFactory(args);
        return controllerFactory.getController();
    }
}
