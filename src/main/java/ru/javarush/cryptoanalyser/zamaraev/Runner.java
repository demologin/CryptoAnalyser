package ru.javarush.cryptoanalyser.zamaraev;

import ru.javarush.cryptoanalyser.zamaraev.toplevel.Application;
import ru.javarush.cryptoanalyser.zamaraev.controller.MainController;
import ru.javarush.cryptoanalyser.zamaraev.entity.Result;
import ru.javarush.cryptoanalyser.zamaraev.util.SelectMode;


public class Runner {
    @SuppressWarnings("AccessStaticViaInstance")
    public static void main(String[] args) {
        MainController mainController = new MainController();

        Application application = new Application(mainController);

        Result result = application.run(new SelectMode().parameters);
        System.out.println(result);
    }
}
