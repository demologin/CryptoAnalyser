package ru.javarush.cryptoanalyzer.rantsev;

import picocli.CommandLine;
import ru.javarush.cryptoanalyzer.rantsev.controller.MainController;
import ru.javarush.cryptoanalyzer.rantsev.picocli.Picocli;
import ru.javarush.cryptoanalyzer.rantsev.picocli.PicocliApp;

public class PicocliRunner {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        PicocliApp application = new PicocliApp(mainController);
        Picocli command = new Picocli(application);
        CommandLine commandLine = new CommandLine(command);
        commandLine.execute(args);
    }
}
