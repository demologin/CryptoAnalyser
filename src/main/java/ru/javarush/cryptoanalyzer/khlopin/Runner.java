package ru.javarush.cryptoanalyzer.khlopin;


import ru.javarush.cryptoanalyzer.khlopin.controller.Controller;


public class Runner {
    public static void main(String[] args) {
        Controller.init();
        Controller.run();
    }
}
