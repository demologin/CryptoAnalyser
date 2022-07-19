package ru.javarush.cryptoanalyzer.molchanov;

import ru.javarush.cryptoanalyzer.molchanov.toplevel.Application;
import ru.javarush.cryptoanalyzer.molchanov.controller.MainController;
import ru.javarush.cryptoanalyzer.molchanov.entity.Result;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        Application application = new Application(mainController);
        System.out.println(Arrays.toString(args));
        Result result = application.run(args);
        System.out.println(result.toString());
        // statisticanalise encoded.txt textForStatisticAnalise.txt
        // encode text.txt encoded.txt 20
        // decode encoded.txt decoded.txt 20
        // bruteforce encoded.txt decoded.txt

    }
}
