package ru.javarush.cryptoanalyzer.petrochenko;

import ru.javarush.cryptoanalyzer.petrochenko.constants.MainMenu;
import ru.javarush.cryptoanalyzer.petrochenko.controller.Commands;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        System.out.print(MainMenu.mainManu);
        //TODO Code style. Many warnings. Skip or fix it.
        Commands commands = new Commands();
    }
}
