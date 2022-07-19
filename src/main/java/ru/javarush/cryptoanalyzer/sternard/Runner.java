package ru.javarush.cryptoanalyzer.sternard;

import ru.javarush.cryptoanalyzer.sternard.controller.Controller;

public class Runner {
    public static void main(String[] args) {
        //TODO ---  only controller? why?
        Controller controller = new Controller();
        controller.run(args);
    }
}