package ru.javarush.cryptoanalyser.khlopin;


import ru.javarush.cryptoanalyser.khlopin.controller.Controller;


public class Runner {
    public static void main(String[] args) {
        Controller.init();
        Controller.run();
    }
}
