package ru.javarush.cryptoanalyser.alimin;

import ru.javarush.cryptoanalyser.alimin.controller.CryptoController;

public class Launcher {
    public static void main(String[] args) {
        CryptoController controller = new CryptoController();
        controller.run();
    }
}
