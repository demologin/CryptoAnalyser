package ru.javarush.cryptoanalyzer.letashko;

import ru.javarush.cryptoanalyzer.letashko.controller.MainController;
import ru.javarush.cryptoanalyzer.letashko.entity.Result;
import ru.javarush.cryptoanalyzer.letashko.swing.SwingInter;
import ru.javarush.cryptoanalyzer.letashko.toplevel.Application;

public class Runner {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        Application application = new Application(mainController);
        Result result=application.run(args);
        System.out.println(result);
    }

    public static class SwingRunner {

        public static void main(String[] args) {

            SwingInter swingInter = new SwingInter();
        }


}}
