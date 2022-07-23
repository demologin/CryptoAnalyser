package ru.javarush.cryptoanalyzer.cherepovskiy.Runner;

import ru.javarush.cryptoanalyzer.cherepovskiy.app.Application;

public class ConsoleRunner {
    //TODO ---  package name (see code convrntion)
    public static void main(String[] args) {
        Application application = new Application();
        application.run(args);
    }
}
