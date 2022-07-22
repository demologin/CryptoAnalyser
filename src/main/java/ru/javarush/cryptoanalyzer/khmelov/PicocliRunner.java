package ru.javarush.cryptoanalyzer.khmelov;

import picocli.CommandLine;
import ru.javarush.cryptoanalyzer.khmelov.controller.MainController;
import ru.javarush.cryptoanalyzer.khmelov.view.picocli.Picocli;
import ru.javarush.cryptoanalyzer.khmelov.view.picocli.PicocliApp;

public class PicocliRunner {
    public static void main(String[] args) {
        //app build
        MainController mainController = new MainController();
        PicocliApp application = new PicocliApp(mainController);

        //run picocli
        Picocli command = new Picocli(application);
        CommandLine commandLine = new CommandLine(command);
        int exitCode = commandLine.execute(args);

        //return result
        System.exit(exitCode);
    }
}
