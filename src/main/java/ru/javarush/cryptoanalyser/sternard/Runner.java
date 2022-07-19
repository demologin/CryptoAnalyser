package ru.javarush.cryptoanalyser.sternard;

import ru.javarush.cryptoanalyser.sternard.controller.Controller;

public class Runner {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.run(args);
    }
}