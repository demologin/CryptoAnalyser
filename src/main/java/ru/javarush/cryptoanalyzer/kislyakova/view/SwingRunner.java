package ru.javarush.cryptoanalyzer.kislyakova.view;

import ru.javarush.cryptoanalyzer.kislyakova.controller.MainController;
import ru.javarush.cryptoanalyzer.kislyakova.view.swing.SwingApp;

public class SwingRunner {

    public static void main(String[] args) {
        //и в раннере запускаем свинг форм
        MainController mainController = new MainController();
        SwingApp swingApp = new SwingApp();
    }
}
