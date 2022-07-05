package ru.javarush.cryptoanaliser.khmelov;

import ru.javarush.cryptoanaliser.khmelov.app.Application;
import ru.javarush.cryptoanaliser.khmelov.controller.MainController;

public class Runner {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        Application application = new Application(mainController);
        Result result=application.run(args);
        System.out.println(result);
    }

}
