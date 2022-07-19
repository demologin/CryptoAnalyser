package ru.javarush.cryptoanalyser.shchukina;

import ru.javarush.cryptoanalyser.shchukina.app.Application;
import ru.javarush.cryptoanalyser.shchukina.controller.MainController;
import ru.javarush.cryptoanalyser.shchukina.entity.Result;

public class AppLauncher {
    public static void main(String[] args) {
        MainController mainController = new MainController();

        Application application = new Application(mainController);
        Result result = application.run();

        if (result != null) {
            System.out.println(result);
        }
    }
}
