package ru.javarush.cryptoanalyzer.khmelov;

import ru.javarush.cryptoanalyzer.khmelov.controller.MainController;
import ru.javarush.cryptoanalyzer.khmelov.view.swing.MainForm;

public class SwingRunner {
    public static void main(String[] args) {
        //build swing app
        MainController controller = new MainController();
        MainForm mainForm = new MainForm(controller);

        //run swing app
        mainForm.initialization();
    }
}
