package ru.javarush.cryptoanalyzer.petrov;


import ru.javarush.cryptoanalyzer.petrov.function.ModeChooser;

public class Runner {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(
                () -> new ModeChooser()
        );}
}

