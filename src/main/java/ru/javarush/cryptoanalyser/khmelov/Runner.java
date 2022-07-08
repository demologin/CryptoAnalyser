package ru.javarush.cryptoanalyser.khmelov;

import ru.javarush.cryptoanalyser.khmelov.toplevel.Application;
import ru.javarush.cryptoanalyser.khmelov.controller.MainController;
import ru.javarush.cryptoanalyser.khmelov.entity.Result;

public class Runner {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        //encode text.txt encoded.txt 45
        Application application = new Application(mainController);
        Result result=application.run(args);
        System.out.println(result);
    }

}
