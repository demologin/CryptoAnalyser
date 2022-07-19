package ru.javarush.cryptoanalyser.kislyakova.view;

import ru.javarush.cryptoanalyser.kislyakova.controller.MainController;
import ru.javarush.cryptoanalyser.kislyakova.view.swing.SwingApp;

public class SwingRunner {

    public static void main(String[] args) {
        //и в раннере запускаем свинг форм
        MainController mainController = new MainController();
        SwingApp swingApp = new SwingApp();
    }
}
